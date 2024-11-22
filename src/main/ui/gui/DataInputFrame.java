package ui.gui;

import javax.swing.*;

import model.data.DoubleData;
import model.dataset.DoubleDataSet;
import model.dataspace.DataSpace;
import model.dataspace.DataVector;
import ui.StatFriendly;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// a text field for user to provide data entries for a given data vector 
// in a given data space
public class DataInputFrame extends JFrame {
    JTextField textField;
    JPanel panel;
    JButton button;
    DataSpace dataSpace;
    DoubleDataSet dataSet;
    DataVector dataVector;
    String prompt;

    // MODIFIES: this, dataVector, and dataSpace
    // EFFECTS: sets up window for user with given prompt and a text field
    // for user input to fill dataVector
    public DataInputFrame(String prompt, DataVector dataVector, DataSpace dataSpace) {
        this.prompt = prompt;
        this.dataVector = dataVector;
        dataSet = dataVector.getDataSet();
        this.dataSpace = dataSpace;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(StatFriendly.WIDTH, StatFriendly.HEIGHT));
        setLayout(new GridLayout(3, 0));
        panel = new JPanel();

        initPrompt();
        initTextField();
        initButton();
        add(textField, BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);
        add(button, BorderLayout.SOUTH);

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

    // MODIFIES: this
    // EFFECTS: sets up done button for user to indicate the end of input
    private void initButton(){
        button = new JButton("Done");
        button.setFont(new Font("Impact", Font.PLAIN, 27));
        button.setForeground(StatFriendly.MAIN_TEXT_COLOUR);
        button.setFocusPainted(false);
        button.addActionListener(new MouseEvent());
        panel.add(button);
    }

    // Implementation for ActionListener to read the enter key clicked in the
    // text field
    private class KeyEvent implements ActionListener {

        // MODIFIES: this
        // EFFECTS: if enter key pressed then enter data entry into data vector
        @Override
        public void actionPerformed(ActionEvent e) {
            if (textField.getText() == "") {
                dataSet.addData(new DoubleData(0.0));
            } else {
                dataSet.addData(new DoubleData(Double.parseDouble(textField.getText())));
            }
            textField.setText("");
        }
    }

    // Implementation for ActionListener to read a button click
    private class MouseEvent implements ActionListener {

        // MODIFIES: this
        // if "Done" button clicked then take user to the interface
        // for data sets in data space
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Done")) {
                new OptionFrame(dataVector, dataSpace);
                dispose();
            }
        }
    }

}
