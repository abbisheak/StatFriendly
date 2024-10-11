package ui;

import model.StatCalculator;
import model.data.DoubleData;
import model.dataset.DoubleDataSet;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

// Statistical analysis app, made with reference to TellerApp
public class StatFriendly {
    private StatCalculator calculator = new StatCalculator();
    private DoubleDataSet userDoubleDataSet;
    private Scanner input = new Scanner(System.in);

    // Effects: runs the StatFriendly app
    public StatFriendly() {
        runStatFriendly();
    }

    // Modifies: this
    // Effects: processes whether the user would like to use the app
    private void runStatFriendly() {
        Boolean quit = false;
        String userInput = null;

        while (!quit) {
            displayMenu();

            userInput = input.next();
            userInput = userInput.toLowerCase();

            if (userInput.equals("q")) {
                quit = true;
            } else {
                init();
            }
            input = new Scanner(System.in);
        }

        System.out.println("Goodbye!");
    }

    // Modifies: this
    // Effects: initializes data sets depending on whether user has
    // sample data or population data
    private void init() {
        Boolean quit = false;
        String userInput = null;

        while (!quit) {
            input = new Scanner(System.in);
            displaySelection();
            userInput = input.next();
            userInput = userInput.toLowerCase();
            if (userInput.equals("s")) {
                continuousDataAnalysis(true);
            } else if (userInput.equals("p")) {
                continuousDataAnalysis(false);
            } else if (userInput.equals("q")) {
                quit = true;
            } else {
                System.out.println("Input not valid!");
            }
        }
    }

    // Modifies: this
    // Effects: Inputs user's data into data sets
    public void continuousDataAnalysis(Boolean isSample) {
        Boolean quit = false;
        Double userDataInput = null;
        String userInput = null;
        userDoubleDataSet = new DoubleDataSet(isSample);

        while (!quit) {
            input = new Scanner(System.in);
            System.out.println("Enter your data:");
            userDataInput = input.nextDouble();
            userDoubleDataSet.addData(new DoubleData(userDataInput));

            input = new Scanner(System.in);
            System.out.println("Add more data?");
            System.out.println("(q) -> No");
            System.out.println("Enter anything else -> Yes");
            userInput = input.next();
            userInput.toLowerCase();
            System.out.println(userInput);
            if (userInput.equals("q")) {
                quit = true;
            }
        }

        analyzeDataDD();
    }

    // Modifies: this
    // Effects: allows user to view information about their data set
    // and/or add elements to their data set
    public void analyzeDataDD() {
        Boolean quit = false;
        String userInput = null;
        int userSelection;
        while (!quit) {
            displayInformationOptions();
            userSelection = input.nextInt();
            optionsDD(userSelection);

            System.out.println("View more?");
            System.out.println("(q) -> No");
            System.out.println("Enter anything else -> Yes");
            userInput = input.next();
            userInput.toLowerCase();
            if (userInput.equals("q")) {
                quit = true;
            }
        }
    }

    // Modifies: this
    // Effects: based on user's input view's or add's to data set
    public void optionsDD(int selection) {
        if (selection == 1) {
            System.out.println(userDoubleDataSet.getMean());

        } else if (selection == 2) {
            System.out.println(userDoubleDataSet.getMedian());
        } else if (selection == 3) {
            System.out.println(userDoubleDataSet.getMode());
        } else if (selection == 4) {
            System.out.println(userDoubleDataSet.getMax());
        } else if (selection == 5) {
            System.out.println(userDoubleDataSet.getMin());
        } else if (selection == 6) {
            System.out.println(userDoubleDataSet.getStandardDeviation());
        } else if (selection == 7) {
            iterate();
        } else if (selection == 8) {
            ArrayList<Double> confidenceLevel = calculator.calculateConfidenceInterval(0.95,
                    userDoubleDataSet.getMean(),
                    userDoubleDataSet.getData().size(), userDoubleDataSet.getStandardDeviation());
            System.out
                    .println("With a 95% level the range is [" + confidenceLevel.get(0) + confidenceLevel.get(1) + "]");
        }
    }

    public void iterate() {
        HashSet<DoubleData> datas = userDoubleDataSet.getData();

        iterateMenu();
        int userSelection;
        input = new Scanner(System.in);
        userSelection = input.nextInt();

        if (userSelection == 1) {
            addElement();
        } else if (userSelection == 2) {
            for (DoubleData d : datas) {
                System.out.println(d.getData());
            }
        }
    }

    // Modifies: this
    // Effects: adds user's input to data set
    public void addElement() {
        System.out.println("Enter the value of the data you would like to add:");
        input = new Scanner(System.in);
        userDoubleDataSet.addData(new DoubleData(input.nextDouble()));
    }

    private void displayMenu() {
        System.out.println("Welcome to StatFriendly!");
        System.out.println("\nSelect from:");
        System.out.println("(y) -> Start statistical analysis");
        System.out.println("(q) -> Quit");
    }

    private void displaySelection() {
        System.out.println("What type of data would you be working with?");
        System.out.println("\nSelect from:");
        System.out.println("(s) -> Continuous sample data");
        System.out.println("(p) -> Continuous population data");
        System.out.println("(q)  -> Quit");
    }

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
        System.out.println("(8) -> Confidence Interval");
        System.out.println("Anything else to start a new data set or quit");
    }

    public void iterateMenu() {
        System.out.println("Select one of the options:");
        System.out.println("(1) -> Add Element");
        System.out.println("(2) -> View all elements in data set");
        System.out.println("Anything else to exit");
    }
}
