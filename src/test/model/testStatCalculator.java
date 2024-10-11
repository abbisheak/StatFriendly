package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.dataset.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class testStatCalculator {
    private static final Double MAX_ACCURACY = 0.00001;

    StatCalculator testStatCalculator;
    DoubleDataSet testDoubleData;
    LongDataSet testLongData;

    @BeforeEach
    public void runBefore(){
        testStatCalculator = new StatCalculator();
    }

    @Test
    public void testCalculateConfidenceInterval(){
        ArrayList<Double> doubleCI1 = testStatCalculator.calculateConfidenceInterval(0.95, 20.6, 30, 8.3);
        ArrayList<Double> doubleCI2 = testStatCalculator.calculateConfidenceInterval(0.95, 1.8, 30, 0.32);

        assertTrue(Math.abs(17.630 - doubleCI1.get(0)) < MAX_ACCURACY);
        assertTrue(Math.abs(23.570 - doubleCI1.get(1)) < MAX_ACCURACY);
        assertTrue(Math.abs(1.685 - doubleCI2.get(0)) < MAX_ACCURACY);
        assertTrue(Math.abs(1.915 - doubleCI2.get(1)) < MAX_ACCURACY);
    }

    @Test
    public void testOneTailLesserHypothesisTest(){
        assertFalse(testStatCalculator.oneTailLesserHypothesisTest(0.95, -1.9, (3.5 / Math.sqrt(30)), false));
        assertFalse(testStatCalculator.oneTailLesserHypothesisTest(0.95, 1.98, (1.8 / Math.sqrt(30)), true));
        assertTrue(testStatCalculator.oneTailLesserHypothesisTest(0.95, -0.1, (3.5 / Math.sqrt(30)), false));
        assertTrue(testStatCalculator.oneTailLesserHypothesisTest(0.95, 1.98, (1.8 / Math.sqrt(30)), true));
    }

    @Test
    public void testOneTailGreaterHypothesisTest(){
        assertFalse(testStatCalculator.oneTailGreaterHypothesisTest(0.95, 5.44, (10.3 / Math.sqrt(30)), true));
        assertFalse(testStatCalculator.oneTailGreaterHypothesisTest(0.95, 1.98, (1.8 / Math.sqrt(30)), true));
        assertTrue(testStatCalculator.oneTailGreaterHypothesisTest(0.95, 0.7, (3.5 / Math.sqrt(30)), false));
        assertTrue(testStatCalculator.oneTailGreaterHypothesisTest(0.95, -13.46, (10.3 / Math.sqrt(30)), true));
    }

    @Test
    public void testTwoTailHypothesisTest(){
        assertFalse(testStatCalculator.twoTailHypothesisTest(0.95, 13.8, (1.82 / Math.sqrt(30)), false));
        assertFalse(testStatCalculator.twoTailHypothesisTest(0.95, 8.8, (5.2 / Math.sqrt(30)), true));
        assertTrue(testStatCalculator.twoTailHypothesisTest(0.95, 8.0, (1.82 / Math.sqrt(30)), false));
        assertTrue(testStatCalculator.twoTailHypothesisTest(0.95, 1.0, (10.3 / Math.sqrt(30)), true));
    }
}
