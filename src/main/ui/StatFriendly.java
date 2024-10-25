package ui;

import model.StatCalculator;
import model.data.DoubleData;
import model.dataset.DoubleDataSet;
import model.dataspace.DataSpace;
import model.dataspace.DataVector;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.List;

// Statistical analysis app, made with reference to TellerApp
public class StatFriendly {
    private StatCalculator calculator = new StatCalculator();
    private Scanner input = new Scanner(System.in);
    private DataSpace userDataSpace;

    // EFFECTS: runs the StatFriendly app
    public StatFriendly() {
        runStatFriendly();
    }

    // MODIFIES: this
    // EFFECTS: processes whether the user would like to use the app
    // and if they would, start a new file or load from a previous
    private void runStatFriendly() {
        Boolean quit = false;
        String userInput = null;

        while (!quit) {
            displayMenu();
            userInput = input.next();
            userInput = userInput.toLowerCase();

            if (userInput.equals("q")) {
                quit = true;
            } else if (userInput.equals("l")) {
                try {
                    loadDataSpace();
                } catch (IOException e) {
                    System.out.println("This file does not exist");
                }
            } else if (userInput.equals("n")) {
                newDataSpace();
            }
            input = new Scanner(System.in);
        }

        System.out.println("Goodbye!");
    }

    // MODIFIES: this
    // EFFECTS: creates a new data space project for user to provide data to
    private void newDataSpace() {
        System.out.println("Name your project:");
        input = new Scanner(System.in);
        String projectName = input.nextLine();
        userDataSpace = new DataSpace(projectName);
        init();
    }

    // MODIFIES: this
    // EFFECTS: if user has a previosly saved Data Space then loads last saved data
    // space by user
    private void loadDataSpace() throws IOException {
        userDataSpace = new JsonReader("./data/userDataSpace.json").read();
        if (userDataSpace.getName() != "") {
            init();
        } else {
            System.out.println("You do not have a previous saved Data Space! Start a new Data Space.");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes data sets depending on whether user has
    // sample data or population data
    private void init() {
        Boolean quit = false;
        String userInput = null;

        while (!quit) {
            input = new Scanner(System.in);
            displaySelection();
            userInput = input.next();
            userInput = userInput.toLowerCase();
            if (userInput.equals("a")) {
                addDataVector();
            } else if (userInput.equals("v")) {
                viewDataVectors();
            } else if (userInput.equals("s")) {
                save();
                quit = true;
            } else if (userInput.equals("q")) {
                quit = true;
            } else {
                System.out.println("Input not valid!");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: add's a data vector to user's data space
    public void addDataVector() {
        DataVector userDataVector;
        DoubleDataSet userDataSet = new DoubleDataSet(false);
        input = new Scanner(System.in);

        System.out.println("What would you like to name this set of entries?");
        String dataName = input.nextLine();

        receiveEntries(userDataSet);
        userDataVector = new DataVector(dataName, userDataSet);
        userDataSpace.addDataVector(userDataVector);
    }

    // MODIFIES: this
    // EFFECTS: allow's user to view/modify the data vectors in their data space
    public void viewDataVectors() {
        input = new Scanner(System.in);
        List<DataVector> userDataVectors = userDataSpace.getDataVectors();
        DataVector userDataVector;
        if (userDataVectors.size() != 0) {
            System.out.println("Select which set of entries you would like to view");
            for (int i = 0; i < userDataVectors.size(); i++) {
                userDataVector = userDataVectors.get(i);
                System.out.println(i + ": " + userDataVector.getName());
            }
            int userInput = input.nextInt();
            viewDataVector(userDataVectors.get(userInput));
        } else {
            System.out.println("This project is empty! Add a Data Set first to view.\\");
        }
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
        writer.write(userDataSpace);
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: Inputs user's data into data sets
    private void receiveEntries(DoubleDataSet userDataSet) {
        Boolean quit = false;
        Double userDataInput = null;
        String userInput = null;

        while (!quit) {
            input = new Scanner(System.in);
            System.out.println("\nEnter your data (Must be a number):");
            userDataInput = input.nextDouble();
            userDataSet.addData(new DoubleData(userDataInput));
            input = new Scanner(System.in);
            System.out.println("Add more data?\n");
            System.out.println("(q) -> No");
            System.out.println("Enter anything else -> Yes\n");
            userInput = input.next();
            userInput.toLowerCase();
            System.out.println(userInput);
            if (userInput.equals("q")) {
                quit = true;
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: allows user to view information about their data vector
    // and/or add elements to their data vector's data set
    private void viewDataVector(DataVector userDataVector) {
        Boolean quit = false;
        String userInput = null;
        int userSelection;
        while (!quit) {
            displayInformationOptions();
            userSelection = input.nextInt();
            optionsDD(userSelection, userDataVector.getDataSet());

            System.out.println("\nView more?\n");
            System.out.println("(q) -> No");
            System.out.println("Enter anything else -> Yes");
            userInput = input.next();
            userInput.toLowerCase();
            if (userInput.equals("q")) {
                quit = true;
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: based on user's input view's or add's to data set
    private void optionsDD(int selection, DoubleDataSet userDataSet) {
        if (selection == 1) {
            System.out.println("\nMean:" + userDataSet.getMean());
        } else if (selection == 2) {
            System.out.println("\nMedian:" + userDataSet.getMedian());
        } else if (selection == 3) {
            System.out.println("\nMode:" + userDataSet.getMode());
        } else if (selection == 4) {
            System.out.println("\nMax:" + userDataSet.getMax());
        } else if (selection == 5) {
            System.out.println("\nMin:" + userDataSet.getMin());
        } else if (selection == 6) {
            System.out.println("\nStandard Deviation:" + userDataSet.getStandardDeviation());
        } else if (selection == 7) {
            iterate(userDataSet);
        } else if (selection == 8) {
            ArrayList<Double> confidenceLevel = calculator.calculateConfidenceInterval(0.95,
                    userDataSet.getMean(),
                    userDataSet.getData().size(), userDataSet.getStandardDeviation());
            System.out
                    .println("Confidence Interval:[" + confidenceLevel.get(0) + "," + confidenceLevel.get(1) + "]");
        }
    }

    // MODIFIES: this
    // EFFECTS: User can either add an element to the data set or
    // view each element of their data set
    private void iterate(DoubleDataSet userDataSet) {
        HashSet<DoubleData> datas = userDataSet.getData();

        iterateMenu();
        int userSelection;
        input = new Scanner(System.in);
        userSelection = input.nextInt();

        if (userSelection == 1) {
            addElement(userDataSet);
        } else if (userSelection == 2) {
            for (DoubleData d : datas) {
                System.out.println(d.getData());
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: adds user's input to data set
    private void addElement(DoubleDataSet userDataSet) {
        System.out.println("Enter the value of the data you would like to add:");
        input = new Scanner(System.in);
        userDataSet.addData(new DoubleData(input.nextDouble()));
    }

    // EFFECTS: Asks user whether they would like to use the app by starting a
    // new data space, or loading a previous data space, or if would like to quit
    private void displayMenu() {
        System.out.println("Welcome to StatFriendly!");
        System.out.println("\nSelect from:\n");
        System.out.println("(n) -> Start new Data Space");
        System.out.println("(l) -> Load last Data Space");
        System.out.println("(q) -> Quit");
    }

    // EFFECTS: Asks user whether would like to add data sets to their data space,
    // view data sets in their data space, save their data space onto a file and
    // quit, or quit without saving
    private void displaySelection() {
        System.out.println("What would you like to do with your Data Space");
        System.out.println("\nSelect from:");
        System.out.println("(a) -> add a Data Set to your Data Space");
        System.out.println("(v) -> view a Data Set in your Data Space");
        System.out.println("(s) -> Save and Quit");
        System.out.println("(q) -> Quit");
    }

    // EFFECTS: Asks user what they would like to do with their processed data
    private void displayInformationOptions() {
        System.out.println("Choose what information you would like to look at for your data:");
        System.out.println("\nSelect from:");
        System.out.println("(1) -> Mean");
        System.out.println("(2) -> Median");
        System.out.println("(3) -> Mode");
        System.out.println("(4) -> Max");
        System.out.println("(5) -> Min");
        System.out.println("(6) -> Standard Deviation");
        System.out.println("(7) -> View/Add Inputted Data");
        System.out.println("(8) -> Confidence Interval (Only accurate when 30 inputs are given)");
        System.out.println("(0) -> Quit and/or make a new data set");
    }

    // EFFECTS: Asks user whether they would like to view their inputs or
    // add an input to the data set
    private void iterateMenu() {
        System.out.println("Choose what you would like to do with your data set:\n");
        System.out.println("Select one of the options:");
        System.out.println("(1) -> Add Element");
        System.out.println("(2) -> View all elements in data set");
        System.out.println("Enter anything else to exit\n");
    }
}
