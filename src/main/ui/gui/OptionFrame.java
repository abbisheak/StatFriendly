package ui.gui;

import javax.swing.*;

import java.util.List;
import java.util.ArrayList;

import model.dataspace.DataSpace;
import model.dataspace.DataVector;
import persistence.JsonWriter;
import ui.StatFriendly;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// A window of options that the user can select to choose
// which window they would like to advance to 
public class OptionFrame extends JFrame {
    private DataSpace dataSpace;
    private List<DataVector> dataVectors;
    private DataVector dataVector;
    private List<JButton> buttons;
    private JPanel panel;
    private MouseEvent event = new MouseEvent();

    // MODIFIES: this and dataSpace
    // EFFECTS: displays a window with buttons corresponding to dataVectors
    // in the dataSpace for the user to specify which is to be accessed
    public OptionFrame(DataSpace dataSpace) {
        this.dataSpace = dataSpace;
        dataVectors = dataSpace.getDataVectors();

        init();
        addButtons(dataVectorsToButtons());
    }

    // MODIFIES: this, dataVector, and dataSpace
    // EFFECTS: displays a window for the user to choose whether they would
    // like to view the information in their data vector or add data entries
    // to the data vector
    public OptionFrame(DataVector dataVector, DataSpace dataSpace) {
        this.dataSpace = dataSpace;
        this.dataVector = dataVector;

        init();
        buttons.add(new JButton("View Data"));
        buttons.add(new JButton("Add Data"));
        buttons.add(new JButton("Go Back"));
        addButtons(buttons);
    }

    // MODIFIES: this
    // EFFECTS: adds stylized buttons to this panel
    private void addButtons(List<JButton> buttons) {
        for (JButton button : buttons) {
            button.setFont(new Font("Impact", Font.PLAIN, 27));
            button.setForeground(StatFriendly.MAIN_TEXT_COLOUR);
            button.setFocusPainted(false);
            button.addActionListener(event);
            panel.add(button);
        }
        add(panel, BorderLayout.CENTER);
    }

    // MODIFIES: this
    // EFFECTS: sets up the panel for this
    private void init() {

        panel = new JPanel();
        buttons = new ArrayList<>();
        setSize(new Dimension(StatFriendly.WIDTH, StatFriendly.HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(3, 3));
        panel.setBackground(StatFriendly.BACKGROUND_COLOUR);
        setVisible(true);
    }

    // EFFECTS: returns corresponding buttons for each data vector in dataSpace
    private List<JButton> dataVectorsToButtons() {
        for (DataVector dataVector : dataVectors) {
            dataVectorToButton(dataVector);
        }
        JButton button1 = new JButton("Add New Data Vector");
        JButton button2 = new JButton("Save and Quit");
        JButton button3 = new JButton("Quit");
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        return buttons;
    }

    // EFFECTS: adds a button into buttons for the given data vector
    private void dataVectorToButton(DataVector dataVector) {
        JButton button = new JButton(dataVector.getName());
        buttons.add(button);
    }

    // MODIFIES: userDataSpace.json
    // EFFECTS: saves data space state onto a file
    private void save() {
        JsonWriter writer = new JsonWriter("./data/userDataSpace.json");
        try {
            writer.open();
        } catch (IOException e) {
            System.out.println("Something went wrong when saving your work");
        }
        writer.write(dataSpace);
        writer.close();
    }

    // Implementation for ActionListener to read a button click
    private class MouseEvent implements ActionListener {

        // MODIFIES: this
        // EFFECTS: reads users choice of button clicked,
        // if dataVector button is clicked then take user to menu to choose to
        // either view their data vector or add data entries to their data vector
        // if "View Data" button clicked then take user to the interface
        // that displays statistical information for data in the data vector
        // if "Add Data" button clicked then take user to the interface to enter
        // their desired entries
        // if "Go Back" button clicked then take user to the interface
        // for data sets in data space
        // if "Save and Quit" then save the user's data and exit the application
        // if "Quit" then exit the application
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (dataSpace.getNames().contains(command)) {
                new OptionFrame(dataSpace.getDataVector(command), dataSpace);
                dispose();
            } else if (command.equals("View Data")) {
                new DataFrame(dataVector, dataSpace);
                dispose();
            } else if (command.equals("Add Data")) {
                new DataInputFrame("Enter Your Numerical Data", dataVector, dataSpace);
                dispose();
            } else if (command.equals("Add New Data Vector")) {
                new DataVectorInputFrame("Enter The Name of Your Data Vector:", dataSpace);
                dispose();
            } else if (command.equals("Go Back")) {
                new OptionFrame(dataSpace);
                dispose();
            } else if (command.equals("Save and Quit")) {
                save();
                System.exit(0);
            } else if (command.equals("Quit")) {
                System.exit(0);
            }
        }

    }
}
