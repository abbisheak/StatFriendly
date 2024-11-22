package ui.gui;

import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;
import model.data.DoubleData;
import model.dataset.DoubleDataSet;
import ui.StatFriendly;

// A boxplot diagram for a data set
public class BoxPlot extends JPanel {
    private int width;
    private int height;
    private int boxWidth;
    private int boxHeight;
    private int boxX;
    private int boxY;
    private DoubleDataSet dataSet;
    private ArrayList<Double> sortedData;
    private Double quartile1;
    private Double quartile3;
    private Double interQuartileRange;
    private Double lowerWhisker;
    private Double upperWhisker;
    private Double median;
    private Double scale;

    // MODIFIES: this
    // EFFECTS: records the data in given data set and records it's data in
    // increasing order
    public BoxPlot(DoubleDataSet dataSet) {
        this.dataSet = dataSet;
        sortedData = dataSet.sortedData(dataSet.iterator());
    }

    // REQUIRES: numQuartile >= 0, start >= 0, end < sortedData.size()
    // EFFECTS: returns the mean for the specified quartile in a data set
    private Double getQuartile(int numQuartile, int start, int end) {
        DoubleDataSet ds = new DoubleDataSet(true);
        if (start == end) {
            ds.addData(new DoubleData(sortedData.get(end)));
        }
        for (int i = start; i < end; i++) {
            ds.addData(new DoubleData(sortedData.get(i)));
        }

        return ds.getMean();
    }

    // MODIFIES: this
    // EFFECTS: draws the box plot diagram accordingly to data set
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        width = getWidth();
        height = getHeight();
        boxWidth = width / 10;
        boxHeight = height / 2;
        boxX = (width - boxWidth) / 2;
        boxY = (height - boxHeight) / 2;
        scale = boxHeight / (sortedData.get(sortedData.size() - 1) - sortedData.get(0));
        median = dataSet.getMean();
        quartile1 = getQuartile(1, 0, sortedData.size() / 2);
        quartile3 = getQuartile(3, sortedData.size() / 2, sortedData.size());
        interQuartileRange = quartile3 - quartile1;
        lowerWhisker = Math.max(quartile1 - 1.5 * interQuartileRange, sortedData.get(0));
        upperWhisker = Math.min(quartile3 + 1.5 * interQuartileRange, sortedData.get(sortedData.size() - 1));
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int medianY = quartileYDimension(median);
        int quartileOneY = quartileYDimension(quartile1);
        int quartileThreeY = quartileYDimension(quartile3);
        int lowerWhiskerY = quartileYDimension(lowerWhisker);
        int upperWhiskerY = quartileYDimension(upperWhisker);
        render(quartileOneY, quartileThreeY, medianY, lowerWhiskerY, upperWhiskerY, graphics2D);
    }

    // MODIFIES: this
    // EFFECTS: draws the boxPlots diagram onto this
    private void render(int q1, int q2, int q3, int lw, int uw, Graphics2D graphics2D) {
        graphics2D.setBackground(StatFriendly.BACKGROUND_COLOUR);
        graphics2D.setColor(Color.GREEN);
        graphics2D.drawRect(boxX, q3, boxWidth, q1 - q3);
        graphics2D.setColor(Color.RED);
        graphics2D.drawLine(boxX, q2, boxX + boxWidth, q2);
        graphics2D.setColor(Color.BLACK);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawLine(boxX + boxWidth / 2, q3, boxX + boxWidth / 2, uw);
        graphics2D.drawLine(boxX + boxWidth / 2, q1, boxX + boxWidth / 2, lw);
        graphics2D.drawLine(boxX, uw, boxX + boxWidth, uw);
        graphics2D.drawLine(boxX, lw, boxX + boxWidth, lw);
    }

    // REQUIRES: quartile == 1 || quartile == 2 || quartile == 3
    // EFFECTS: returns the end y-coordinate for the given quartile
    private int quartileYDimension(Double quartile) {
        return boxY + boxHeight - (int) ((quartile - sortedData.get(0)) * scale);
    }

    @Override
    // EFFECTS: returns the size of the panel
    public Dimension getPreferredSize() {
        return new Dimension(700, 700);
    }
}
