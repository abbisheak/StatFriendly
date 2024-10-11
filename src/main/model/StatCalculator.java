package model;

import java.util.ArrayList;

// represents a calculator that performs computations for statistical
// analysis
public class StatCalculator {

    public StatCalculator() {
    }

    // Requires: confidenceLevel == 0.95
    // Effects: returns a double containing a lower and upper bound for
    // the confidence interval for a data set with respect to the
    // confidence level
    public ArrayList<Double> calculateConfidenceInterval(Double confidenceLevel, Boolean isSample, Double data, Double standardDeviation) {
        // stub
        return null;
    }

    // Requires: confidenceLevel == 0.95
    // Effects: returns true if the given null hypothesis is failed to be
    // rejected, otherwise return false indicating the null hypothesis is
    // rejected
    public Boolean oneTailLesserHypothesisTest(Double confidenceLevel, Double deviation, Double standardDeviation) {
        // stub
        return null;
    }

    // Requires: confidenceLevel == 0.95
    // Effects: returns true if the given null hypothesis is failed to be
    // rejected, otherwise return false indicating the null hypothesis is
    // rejected
    public Boolean oneTailGreaterHypothesisTest(Double confidenceLevel, Double deviation, Double standardDeviation) {
        // stub
        return null;
    }

    // Requires: confidenceLevel == 0.95
    // Effects: returns true if the given null hypothesis is failed to be
    // rejected, otherwise return false indicating the null hypothesis is
    // rejected
    public Boolean twoTailHypothesisTest(Double confidenceLevel, Double deviation, Double standardDeviation) {
        // stub
        return null;
    }
}
