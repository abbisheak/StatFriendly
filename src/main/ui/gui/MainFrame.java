package ui.gui;

import java.util.List;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main menu window for StatFriendly app that prompts the user
// to either start a new data space, load a previous data space,
// or quit the application
public class MainFrame extends JFrame{
    public final static Color BACKGROUND_COLOUR = Color.LIGHT_GRAY;
    public final static Color MAIN_TEXT_COLOUR = Color.DARK_GRAY;

    private JPanel optionsPanel;
    private JPanel titlePanel;
    private MouseEvent event = new MouseEvent();
    private JButton button1 = new JButton("Create New Data Space");
    private JButton button2 = new JButton("Load Previous Data Space");
    private JButton button3 = new JButton("Quit");

    // MODIFIES: this
    // EFFECTS: sets up main menu window for StatFriendly GUI and all
    // proceeding user interactions
    public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("StatFriendly");
        setSize(new Dimension(1920, 1080));
        initOptionsPanel();
        initTitlePanel();

        pack();
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: initializes segment of main menu window that provides
    // buttons for the user to create a new data space, load a previous
    // data space, or exit
    private void initOptionsPanel(){
        optionsPanel = new JPanel();
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        optionsPanel.setLayout(new GridLayout(3, 0));
        optionsPanel.setBackground(BACKGROUND_COLOUR);
        initButtons();
        add(optionsPanel, BorderLayout.AFTER_LINE_ENDS);
    }

    // MODIFIES: this
    // EFFECTS: initializes buttons for the user to create a new data 
    // space, load a previous data space, or exit
    private void initButtons(){
        List<JButton> buttons = new ArrayList<>();
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);

        for(JButton button : buttons){
            button.addActionListener(event);
            optionsPanel.add(button);
            button.setFont(new Font("Impact", Font.PLAIN, 27));
            button.setForeground(MAIN_TEXT_COLOUR);
            button.setFocusPainted(false); 
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes StatFriendly title on the main menu window
    private void initTitlePanel(){
        titlePanel = new JPanel();
        titlePanel.setBackground(BACKGROUND_COLOUR);
        JLabel label = new JLabel("StatFriendly");
        label.setFont(new Font("Impact", Font.PLAIN, 97));
        label.setForeground(MAIN_TEXT_COLOUR);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        titlePanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        titlePanel.add(label);

        add(titlePanel, BorderLayout.WEST);
    }

    // Implementation for ActionListener to read a button click of the main menu
    private class MouseEvent implements ActionListener{

        // MODIFIES: this
        // EFFECTS: reads users choice of button clicked,
        // if "Create New Data Space" button clicked then take user to name and access
        // a blank data space
        // if "Load Previous Data Space" button clicked then take user to the interface 
        // for data sets in data space, but if no data space is previously saved redirect
        // user back to main menu
        // if "Quit" then quit the application
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Create New Data Space")) {
                // Take user to JFrame to create new space
                // TODO: I NEED TO IMPLEMENT THESE OTHER CLASSES
            } else if (command.equals("Load Previous Data Space")) {
                // Take user to JFrame where they can access previously saved data space
                // TODO: I NEED TO IMPLEMENT THESE OTHER CLASSES
            } else if (command.equals("Quit")) {
                System.exit(0);
            }
        }

    }

}
