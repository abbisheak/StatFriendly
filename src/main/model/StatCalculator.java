package model;

import java.util.ArrayList;

import model.dataset.DoubleDataSet;

// represents a calculator that performs computations for statistical
// analysis
public class StatCalculator {

    public StatCalculator() {
    }

    // Requires: !dataSet.getData().isEmpty()
    // Effects: returns a double containing a lower and upper bound for
    // the confidence interval for a data set with respect to the
    // confidence level
    public ArrayList<Double> calculateConfidenceInterval(Double confidenceLevel, DoubleDataSet dataSet) {
        // stub
        return null;
    }

    // Requires: !dataSet.getData().isEmpty()
    // Effects: returns true if the given null hypothesis is failed to be
    // rejected, otherwise return false indicating the null hypothesis is
    // rejected
    public Boolean oneTailLesserHypothesisTest(Double confidenceLevel, DoubleDataSet dataSet, Double nullHypotheis) {
        return null;
    }

    // Requires: !dataSet.getData().isEmpty()
    // Effects: returns true if the given null hypothesis is failed to be
    // rejected, otherwise return false indicating the null hypothesis is
    // rejected
    public Boolean oneTailGreaterHypothesisTest(Double confidenceLevel, DoubleDataSet dataSet, Double nullHypotheis) {
        return null;
    }

    // Requires: !dataSet.getData().isEmpty()
    // Effects: returns true if the given null hypothesis is failed to be
    // rejected, otherwise return false indicating the null hypothesis is
    // rejected
    public Boolean twoTailHypothesisTest(Double confidenceLevel, DoubleDataSet dataSet, Double hypotheis) {
        return null;
    }
}
