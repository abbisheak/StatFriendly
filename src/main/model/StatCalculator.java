package model;

import java.util.ArrayList;

// represents a calculator that performs computations for statistical
// analysis
public class StatCalculator {
    private static final Double Z_SCORE_CI = 1.96;
    private static final Double T_SCORE_ONE_TAIL = 1.699;
    private static final Double Z_SCORE_ONE_TAIL = 1.645;
    private static final Double T_SCORE_TWO_TAIL = 2.045;

    public StatCalculator() {
    }

    // Requires: confidence == 0.95 AND size == 30
    // Effects: returns a double containing a lower and upper bound for
    // the confidence interval for a data set with respect to the
    // confidence level
    public ArrayList<Double> calculateConfidenceInterval(Double confidence, Double mean, Integer size,
            Double standardDeviation) {
        Double marginOfError = Z_SCORE_CI * (standardDeviation / Math.sqrt(size));
        Double upperBound = mean + marginOfError;
        Double lowerBound = mean - marginOfError;

        ArrayList<Double> confidenceInterval = new ArrayList<>();
        confidenceInterval.add(lowerBound);
        confidenceInterval.add(upperBound);

        return confidenceInterval;
    }

    // Requires: confidence == 0.95 AND size == 30
    // Effects: returns true if the given deviation fails to reject the null
    // hypothesis is failed to be rejected, otherwise return false indicating
    // the null hypothesis is rejected. If isSample use sample method, else
    // use population method
    public Boolean oneTailLesserHypothesisTest(Double confidence, Double deviation, Double standardError,
            Boolean isSample) {
        Double criticalValue;

        if (isSample) {
            criticalValue = -T_SCORE_ONE_TAIL;
        } else {
            criticalValue = -Z_SCORE_ONE_TAIL;
        }

        Double testStatistic = deviation / standardError;
        return testStatistic > criticalValue;
    }

    // Requires: confidence == 0.95 AND size == 30
    // Effects: returns true if the given deviation fails to reject the null
    // hypothesis is failed to be rejected, otherwise return false indicating
    // the null hypothesis is rejected. If isSample use sample method, else
    // use population method
    public Boolean oneTailGreaterHypothesisTest(Double confidence, Double deviation, Double standardError,
            Boolean isSample) {
        Double criticalValue;

        if (isSample) {
            criticalValue = T_SCORE_ONE_TAIL;
        } else {
            criticalValue = Z_SCORE_ONE_TAIL;
        }

        Double testStatistic = deviation / standardError;
        return testStatistic < criticalValue;
    }

    // Requires: confidence == 0.95 AND size == 30
    // Effects: returns true if the given deviation fails to reject the null
    // hypothesis is failed to be rejected, otherwise return false indicating
    // the null hypothesis is rejected. If isSample use sample method, else
    // use population method
    public Boolean twoTailHypothesisTest(Double confidence, Double deviation, Double standardError, Boolean isSample) {
        Double criticalValue = T_SCORE_TWO_TAIL;
        Double testStatistic = deviation / standardError;
        return testStatistic > -criticalValue && testStatistic < criticalValue;
    }
}
