package ui.gui;

import javax.swing.*;

import model.dataset.DoubleDataSet;
import model.dataspace.DataSpace;
import model.dataspace.DataVector;
import ui.StatFriendly;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// a text field to name a data vector in a data space
public class DataVectorInputFrame extends JFrame{
    JTextField textField;
    JPanel panel;
    DataSpace dataSpace;
    String prompt;

    // MODIFIES: this and dataSpace
    // EFFECTS: sets up window for user with given prompt and a text field
    // for user input to name the given data space
    public DataVectorInputFrame(String prompt, DataSpace dataSpace) {
        this.prompt = prompt;
        this.dataSpace = dataSpace;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(StatFriendly.WIDTH, StatFriendly.HEIGHT));
        setLayout(new GridLayout(2, 0));
        panel = new JPanel();

        initPrompt();
        initTextField();
        add(textField, BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);

        pack();
        setVisible(true);
    }

    // MODIFIES: this 
    // EFFECTS: sets up text field on window
    public void initTextField() {
        textField = new JTextField();
        textField.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        textField.setBackground(StatFriendly.BACKGROUND_COLOUR);
        textField.setFont(new Font("IMPACT", Font.CENTER_BASELINE, 27));
        textField.setForeground(StatFriendly.MAIN_TEXT_COLOUR);
        textField.addActionListener(new KeyEvent());
    }

    // MODIFIES: this
    // EFFECTS: sets up prompt message on window
    private void initPrompt() {
        panel.setBackground(StatFriendly.BACKGROUND_COLOUR);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel label = new JLabel(prompt);
        label.setFont(new Font("Impact", Font.PLAIN, 49));
        label.setForeground(StatFriendly.MAIN_TEXT_COLOUR);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(label);
    }

    // Implementation for ActionListener to read the enter key clicked in the
    // text field
    private class KeyEvent implements ActionListener {

        // MODIFIES: this
        // EFFECTS: if enter key pressed then set name of a data vector in this data
        // space and then prompt for data entries
        @Override
        public void actionPerformed(ActionEvent e) {
            DataVector dataVector = new DataVector(textField.getText(), new DoubleDataSet(true));
            dataSpace.addDataVector(dataVector);
            new DataInputFrame("Enter Your Numerical Data", dataVector,  dataSpace);
            dispose();
            textField.setText("");
        }
    }

}
