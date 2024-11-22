package ui.gui;

import javax.swing.*;
import ui.StatFriendly;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import model.StatCalculator;
import model.dataset.DoubleDataSet;
import model.dataspace.*;

// A window that displays the statistical information of a given data set
// along with a scatterplot graph for which the data maps onto
public class DataFrame extends JFrame {
    DataVector dataVector;
    DataSpace dataSpace;
    JPanel boxPlotPanel;
    JPanel statPanel;
    JPanel titlePanel;

    // MODIFIES: this
    // EFFECTS: creates window for statistical information fo given dataVector
    public DataFrame(DataVector dataVector, DataSpace dataSpace) {
        this.dataVector = dataVector;
        this.dataSpace = dataSpace;
        init();

        createStatPanel();
        createTitlePanel();
        createBoxPlotPanel();
        setBackground(StatFriendly.BACKGROUND_COLOUR);
    }

    // MODIFIES: this
    // EFFECTS: setup a window/canvas for the statistical information to go on
    private void init() {
        setSize(new Dimension(StatFriendly.WIDTH, StatFriendly.HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        JPanel fill = new JPanel();
        fill.setSize(new Dimension(1920, 1080));
        fill.setBackground(StatFriendly.BACKGROUND_COLOUR);
        add(fill);

        boxPlotPanel = new BoxPlot(dataVector.getDataSet());
        statPanel = new JPanel();
        titlePanel = new JPanel();
    }

    // MODIFIES: this
    // EFFECTS: adds box plot diagram to window
    private void createBoxPlotPanel() {
        boxPlotPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        boxPlotPanel.setPreferredSize(new Dimension(700, 700));
        boxPlotPanel.setBackground(Color.WHITE);
        add(boxPlotPanel, BorderLayout.EAST);
    }

    // MODIFIES: this
    // EFFECTS: adds name of data vector to window
    private void createTitlePanel() {
        titlePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        titlePanel.setBackground(StatFriendly.BACKGROUND_COLOUR);
        addTitle();
        add(titlePanel, BorderLayout.NORTH);
    }

    // MODIFIES: this
    // EFFECTS: stylizes and adds title to panel for title for window
    private void addTitle() {
        JLabel title = new JLabel(dataVector.getName());
        title.setFont(new Font("Impact", Font.PLAIN, 35));
        title.setForeground(StatFriendly.MAIN_TEXT_COLOUR);
        titlePanel.add(title, BorderLayout.CENTER);
    }

    // MODIFIES: this
    // EFFECTS: adds numerical data for data vector onto window
    private void createStatPanel() {
        statPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        statPanel.setLayout(new GridLayout(0, 1));
        statPanel.setBackground(StatFriendly.BACKGROUND_COLOUR);
        addLabels();
        addButton();
        add(statPanel, BorderLayout.WEST);
    }

    // MODIFIES: this
    // EFFECTS: adds numerical data of data vector to panel
    private void addLabels() {
        List<String> headers = getHeaders();
        JLabel label;

        for (String header : headers) {
            label = new JLabel(header);
            label.setFont(new Font("Impact", Font.PLAIN, 17));
            label.setForeground(StatFriendly.MAIN_TEXT_COLOUR);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            statPanel.add(label);
        }
    }

    // EFFECTS: returns formatted numerical data for a data vector
    // as : <Type>: <Data>
    private List<String> getHeaders() {
        List<String> headers = new ArrayList<>();
        ArrayList<Double> confidenceLevel;
        DoubleDataSet dataSet = dataVector.getDataSet();

        headers.add("Mean:" + dataSet.getMean());
        headers.add("Median:" + dataSet.getMedian());
        headers.add("Mode:" + dataSet.getMode());
        headers.add("Max:" + dataSet.getMax());
        headers.add("Min:" + dataSet.getMin());
        headers.add("Standard Deviation:" + dataSet.getStandardDeviation());
        confidenceLevel = new StatCalculator().calculateConfidenceInterval(0.95,
                dataSet.getMean(), dataSet.getData().size(), dataSet.getStandardDeviation());
        headers.add("Confidence Interval: [" + confidenceLevel.get(0) + "," + confidenceLevel.get(1) + "]");

        return headers;
    }

    // MODIFIES: this
    // EFFECTS: adds a button to take user to the interface
    // for data sets in data space
    private void addButton() {
        JButton button = new JButton("Go Back");
        button.setFont(new Font("Impact", Font.PLAIN, 17));
        button.setForeground(StatFriendly.MAIN_TEXT_COLOUR);
        button.setFocusPainted(false);
        button.addActionListener(new MouseEvent());
        statPanel.add(button);
    }

    // Implementation for ActionListener to read a button click
    private class MouseEvent implements ActionListener {

        // MODIFIES: this
        // if "Go Back" button clicked then take user to the interface
        // for data sets in data space
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Go Back")) {
                new OptionFrame(dataVector, dataSpace);
                dispose();
            }
        }
    }
}
