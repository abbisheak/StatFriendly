package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.data.DoubleData;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class DoubleDataSetTest implements DataSetTest {
    private static final Double MAX_ACCURACY = 0.00001;

    DoubleDataSet testDoubleDataSetSample;
    DoubleDataSet testDoubleDataSetPopulation;

    @BeforeEach
    public void runBefore() {
        testDoubleDataSetSample = new DoubleDataSet(true);
        testDoubleDataSetPopulation = new DoubleDataSet(false);
    }

    @Test
    public void testConstructor() {
        assertTrue(testDoubleDataSetSample.isSample());
        assertFalse(testDoubleDataSetPopulation.isSample());

        assertTrue(testDoubleDataSetPopulation.getData().isEmpty());
        assertTrue(testDoubleDataSetSample.getData().isEmpty());
    }

    @Test
    public void testAddDataOnce() {
        assertTrue(testDoubleDataSetPopulation.getData().isEmpty());
        assertTrue(testDoubleDataSetSample.getData().isEmpty());

        DoubleData dd1 = new DoubleData(90.2);

        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);

        assertTrue(1 == testDoubleDataSetPopulation.size());
        assertTrue(1 == testDoubleDataSetSample.size());
    }

    @Test
    public void testAddDataMultipleTimes() {
        DoubleData dd1 = new DoubleData(90.2);
        DoubleData dd2 = new DoubleData(90.2);
        DoubleData dd3 = new DoubleData(-321.32);

        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);

        assertTrue(1 == testDoubleDataSetPopulation.size());
        assertTrue(1 == testDoubleDataSetSample.size());

        testDoubleDataSetPopulation.addData(dd2);
        testDoubleDataSetSample.addData(dd2);

        assertTrue(2 == testDoubleDataSetPopulation.size());
        assertTrue(2 == testDoubleDataSetSample.size());

        testDoubleDataSetPopulation.addData(dd3);
        testDoubleDataSetSample.addData(dd3);

        assertTrue(3 == testDoubleDataSetPopulation.size());
        assertTrue(3 == testDoubleDataSetSample.size());
    }

    @Test
    public void testAddDataFail() {
        DoubleData dd1 = null;

        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);

        assertTrue(0 == testDoubleDataSetPopulation.size());
        assertTrue(0 == testDoubleDataSetSample.size());

        dd1 = new DoubleData(9.3);
        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);

        assertTrue(1 == testDoubleDataSetPopulation.size());
        assertTrue(1 == testDoubleDataSetSample.size());

        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);

        assertTrue(1 == testDoubleDataSetPopulation.size());
        assertTrue(1 == testDoubleDataSetSample.size());
    }

    @Test
    public void testRemoveDataOnce() {
        DoubleData dd1 = new DoubleData(90.2);

        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);

        assertTrue(1 == testDoubleDataSetPopulation.size());
        assertTrue(1 == testDoubleDataSetSample.size());

        testDoubleDataSetPopulation.removeData(dd1);
        testDoubleDataSetSample.removeData(dd1);

        assertTrue(0 == testDoubleDataSetPopulation.size());
        assertTrue(0 == testDoubleDataSetSample.size());
    }

    @Test
    public void testRemoveDataMultipleTimes() {
        DoubleData dd1 = new DoubleData(90.2);
        DoubleData dd2 = new DoubleData(8321.21);
        DoubleData dd3 = new DoubleData(9034023.1111);

        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);
        testDoubleDataSetPopulation.addData(dd2);
        testDoubleDataSetSample.addData(dd2);
        testDoubleDataSetPopulation.addData(dd3);
        testDoubleDataSetSample.addData(dd3);

        assertTrue(3 == testDoubleDataSetPopulation.size());
        assertTrue(3 == testDoubleDataSetSample.size());

        testDoubleDataSetPopulation.removeData(dd1);
        testDoubleDataSetSample.removeData(dd1);

        assertTrue(2 == testDoubleDataSetPopulation.size());
        assertTrue(2 == testDoubleDataSetSample.size());

        testDoubleDataSetPopulation.removeData(dd3);
        testDoubleDataSetSample.removeData(dd3);

        assertTrue(1 == testDoubleDataSetPopulation.size());
        assertTrue(1 == testDoubleDataSetSample.size());

        testDoubleDataSetPopulation.removeData(dd2);
        testDoubleDataSetSample.removeData(dd2);

        assertTrue(0 == testDoubleDataSetPopulation.size());
        assertTrue(0 == testDoubleDataSetSample.size());
    }

    @Test
    public void testRemoveDataNotInSet() {
        assertTrue(0 == testDoubleDataSetPopulation.size());
        assertTrue(0 == testDoubleDataSetSample.size());

        testDoubleDataSetPopulation.removeData(new DoubleData(823.1));
        testDoubleDataSetSample.removeData(new DoubleData(-2193.1));
        assertTrue(0 == testDoubleDataSetPopulation.size());
        assertTrue(0 == testDoubleDataSetSample.size());

        DoubleData dd1 = new DoubleData(7213.132);
        DoubleData dd2 = new DoubleData(-9021.1);
        testDoubleDataSetPopulation.addData(dd2);
        testDoubleDataSetSample.addData(dd2);
        assertTrue(1 == testDoubleDataSetPopulation.size());
        assertTrue(1 == testDoubleDataSetSample.size());

        testDoubleDataSetPopulation.removeData(dd1);
        testDoubleDataSetSample.removeData(dd1);
        assertTrue(1 == testDoubleDataSetPopulation.size());
        assertTrue(1 == testDoubleDataSetSample.size());

        testDoubleDataSetPopulation.removeData(dd2);
        testDoubleDataSetSample.removeData(dd2);
        assertTrue(0 == testDoubleDataSetPopulation.size());
        assertTrue(0 == testDoubleDataSetSample.size());
        testDoubleDataSetPopulation.removeData(dd2);
        testDoubleDataSetSample.removeData(dd2);
        assertTrue(0 == testDoubleDataSetPopulation.size());
        assertTrue(0 == testDoubleDataSetSample.size());
    }

    @Test
    public void testContains() {
        DoubleData dd1 = new DoubleData(80.21);
        DoubleData dd2 = new DoubleData(-903.2);

        assertFalse(testDoubleDataSetPopulation.contains(dd1));
        assertFalse(testDoubleDataSetSample.contains(dd1));

        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);
        assertTrue(testDoubleDataSetPopulation.contains(dd1));
        assertTrue(testDoubleDataSetSample.contains(dd1));

        assertFalse(testDoubleDataSetPopulation.contains(dd2));
        assertFalse(testDoubleDataSetSample.contains(dd2));
    }

    @Test
    public void testClear() {
        assertTrue(testDoubleDataSetPopulation.getData().isEmpty());
        assertNull(testDoubleDataSetPopulation.getMax());
        assertNull(testDoubleDataSetPopulation.getMean());
        assertNull(testDoubleDataSetPopulation.getMedian());
        assertNull(testDoubleDataSetPopulation.getMin());
        assertNull(testDoubleDataSetPopulation.getMode());
        assertNull(testDoubleDataSetPopulation.getStandardDeviation());

        assertTrue(testDoubleDataSetSample.getData().isEmpty());
        assertNull(testDoubleDataSetSample.getMax());
        assertNull(testDoubleDataSetSample.getMedian());
        assertNull(testDoubleDataSetSample.getMin());
        assertNull(testDoubleDataSetSample.getMode());
        assertNull(testDoubleDataSetSample.getStandardDeviation());

        DoubleData dd1 = new DoubleData(923.1);

        testDoubleDataSetPopulation.addData(dd1);
        assertFalse(testDoubleDataSetPopulation.getData().isEmpty());
        assertNotEquals(null, testDoubleDataSetPopulation.getMax());
        assertNotEquals(null, testDoubleDataSetPopulation.getMean());
        assertNotEquals(null, testDoubleDataSetPopulation.getMedian());
        assertNotEquals(null, testDoubleDataSetPopulation.getMin());
        assertNotEquals(null, testDoubleDataSetPopulation.getMode());
        assertNotEquals(null, testDoubleDataSetPopulation.getStandardDeviation());

        testDoubleDataSetSample.addData(dd1);
        assertFalse(testDoubleDataSetSample.getData().isEmpty());
        assertNotEquals(null, testDoubleDataSetSample.getMax());
        assertNotEquals(null, testDoubleDataSetSample.getMean());
        assertNotEquals(null, testDoubleDataSetSample.getMedian());
        assertNotEquals(null, testDoubleDataSetSample.getMin());
        assertNotEquals(null, testDoubleDataSetSample.getMode());
        assertNotEquals(null, testDoubleDataSetSample.getStandardDeviation());

        testDoubleDataSetPopulation.clear();
        assertTrue(testDoubleDataSetPopulation.getData().isEmpty());
        assertNull(testDoubleDataSetPopulation.getMax());
        assertNull(testDoubleDataSetPopulation.getMean());
        assertNull(testDoubleDataSetPopulation.getMedian());
        assertNull(testDoubleDataSetPopulation.getMin());
        assertNull(testDoubleDataSetPopulation.getMode());
        assertNull(testDoubleDataSetPopulation.getStandardDeviation());

        testDoubleDataSetSample.clear();
        assertTrue(testDoubleDataSetSample.getData().isEmpty());
        assertNull(testDoubleDataSetSample.getMax());
        assertNull(testDoubleDataSetSample.getMedian());
        assertNull(testDoubleDataSetSample.getMin());
        assertNull(testDoubleDataSetSample.getMode());
        assertNull(testDoubleDataSetSample.getStandardDeviation());
    }

    @Test
    public void testIterator() {
        assertFalse(testDoubleDataSetPopulation.iterator().hasNext());
        assertFalse(testDoubleDataSetSample.iterator().hasNext());

        DoubleData dd1 = new DoubleData(-32.132);
        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);

        Iterator<DoubleData> populationIterator = testDoubleDataSetPopulation.iterator();
        Iterator<DoubleData> sampleIterator = testDoubleDataSetSample.iterator();

        assertTrue(populationIterator.hasNext());
        assertTrue(sampleIterator.hasNext());

        assertEquals(dd1, populationIterator.next());
        assertEquals(dd1, sampleIterator.next());

        assertFalse(populationIterator.hasNext());
        assertFalse(sampleIterator.hasNext());
    }

    @Test
    public void testSize() {
        assertTrue(0 == testDoubleDataSetPopulation.size());
        assertTrue(0 == testDoubleDataSetSample.size());

        DoubleData dd1 = new DoubleData(80.21);
        DoubleData dd2 = new DoubleData(-903.2);

        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);
        assertTrue(1 == testDoubleDataSetPopulation.size());
        assertTrue(1 == testDoubleDataSetSample.size());

        testDoubleDataSetPopulation.addData(dd2);
        testDoubleDataSetSample.addData(dd2);
        assertTrue(2 == testDoubleDataSetPopulation.size());
        assertTrue(2 == testDoubleDataSetSample.size());
    }

    @Test
    public void testIsSample() {
        assertTrue(testDoubleDataSetSample.isSample());
        assertFalse(testDoubleDataSetPopulation.isSample());
    }

    @Test
    public void testGetMean() {
        assertNull(testDoubleDataSetPopulation.getMean());
        assertNull(testDoubleDataSetSample.getMean());

        DoubleData dd1 = new DoubleData(50.3);
        DoubleData dd2 = new DoubleData(-30.8);

        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);

        assertTrue(50.3 == testDoubleDataSetPopulation.getMean());
        assertTrue(50.3 == testDoubleDataSetSample.getMean());

        testDoubleDataSetPopulation.addData(dd2);
        testDoubleDataSetSample.addData(dd2);

        assertTrue(Math.abs(testDoubleDataSetPopulation.getMean() - 9.75) < MAX_ACCURACY);
        assertTrue(Math.abs(testDoubleDataSetSample.getMean() - 9.75) < MAX_ACCURACY);
    }

    @Test
    public void testGetMedian() {
        assertNull(testDoubleDataSetPopulation.getMedian());
        assertNull(testDoubleDataSetSample.getMedian());

        DoubleData dd1 = new DoubleData(50.3);
        DoubleData dd2 = new DoubleData(-30.8);
        DoubleData dd3 = new DoubleData(10.3);
        DoubleData dd4 = new DoubleData(40.8);

        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);

        assertTrue(50.3 == testDoubleDataSetPopulation.getMedian());
        assertTrue(50.3 == testDoubleDataSetSample.getMedian());

        testDoubleDataSetPopulation.addData(dd2);
        testDoubleDataSetSample.addData(dd2);

        assertTrue(-30.8 == testDoubleDataSetPopulation.getMedian());
        assertTrue(-30.8 == testDoubleDataSetSample.getMedian());

        testDoubleDataSetPopulation.addData(dd3);
        testDoubleDataSetSample.addData(dd3);

        assertTrue(10.3 == testDoubleDataSetPopulation.getMedian());
        assertTrue(10.3 == testDoubleDataSetSample.getMedian());

        testDoubleDataSetPopulation.addData(dd4);
        testDoubleDataSetSample.addData(dd4);

        assertTrue(10.3 == testDoubleDataSetPopulation.getMedian());
        assertTrue(10.3 == testDoubleDataSetSample.getMedian());
    }

    @Test
    public void testGetMode() {

        assertNull(testDoubleDataSetPopulation.getMode());
        assertNull(testDoubleDataSetSample.getMode());

        DoubleData dd1 = new DoubleData(50.3);
        DoubleData dd2 = new DoubleData(-30.8);
        DoubleData dd3 = new DoubleData(50.3);
        DoubleData dd4 = new DoubleData(50.3);
        DoubleData dd5 = new DoubleData(-30.8);

        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);

        assertTrue(50.3 == testDoubleDataSetPopulation.getMode());
        assertTrue(50.3 == testDoubleDataSetSample.getMode());

        testDoubleDataSetPopulation.addData(dd2);
        testDoubleDataSetSample.addData(dd2);

        assertTrue(-30.8 == testDoubleDataSetPopulation.getMode());
        assertTrue(-30.8 == testDoubleDataSetSample.getMode());

        testDoubleDataSetPopulation.addData(dd3);
        testDoubleDataSetSample.addData(dd3);

        assertTrue(50.3 == testDoubleDataSetPopulation.getMode());
        assertTrue(50.3 == testDoubleDataSetSample.getMode());

        testDoubleDataSetPopulation.addData(dd4);
        testDoubleDataSetSample.addData(dd4);

        assertTrue(50.3 == testDoubleDataSetPopulation.getMode());
        assertTrue(50.3 == testDoubleDataSetSample.getMode());

        testDoubleDataSetPopulation.addData(dd5);
        testDoubleDataSetSample.addData(dd5);

        assertTrue(50.3 == testDoubleDataSetPopulation.getMode());
        assertTrue(50.3 == testDoubleDataSetSample.getMode());
    }

    @Test
    public void testGetMax() {
        assertNull(testDoubleDataSetPopulation.getMax());
        assertNull(testDoubleDataSetSample.getMax());

        DoubleData dd1 = new DoubleData(50.3);
        DoubleData dd2 = new DoubleData(-30.8);
        DoubleData dd3 = new DoubleData(10.3);
        DoubleData dd4 = new DoubleData(50.3);

        testDoubleDataSetPopulation.addData(dd2);
        testDoubleDataSetSample.addData(dd2);

        assertTrue(-30.8 == testDoubleDataSetPopulation.getMax());
        assertTrue(-30.8 == testDoubleDataSetSample.getMax());

        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);

        assertTrue(50.3 == testDoubleDataSetPopulation.getMax());
        assertTrue(50.3 == testDoubleDataSetSample.getMax());

        testDoubleDataSetPopulation.addData(dd3);
        testDoubleDataSetSample.addData(dd3);

        assertTrue(50.3 == testDoubleDataSetPopulation.getMax());
        assertTrue(50.3 == testDoubleDataSetSample.getMax());

        testDoubleDataSetPopulation.addData(dd4);
        testDoubleDataSetSample.addData(dd4);

        assertTrue(50.3 == testDoubleDataSetPopulation.getMax());
        assertTrue(50.3 == testDoubleDataSetSample.getMax());
    }

    @Test
    public void testGetMin() {
        assertNull(testDoubleDataSetPopulation.getMin());
        assertNull(testDoubleDataSetSample.getMin());

        DoubleData dd1 = new DoubleData(50.3);
        DoubleData dd2 = new DoubleData(-30.8);
        DoubleData dd3 = new DoubleData(-10.3);
        DoubleData dd4 = new DoubleData(-30.8);

        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);

        assertTrue(50.3 == testDoubleDataSetPopulation.getMin());
        assertTrue(50.3 == testDoubleDataSetSample.getMin());

        testDoubleDataSetPopulation.addData(dd2);
        testDoubleDataSetSample.addData(dd2);

        assertTrue(-30.8 == testDoubleDataSetPopulation.getMin());
        assertTrue(-30.8 == testDoubleDataSetSample.getMin());

        testDoubleDataSetPopulation.addData(dd3);
        testDoubleDataSetSample.addData(dd3);

        assertTrue(-30.8 == testDoubleDataSetPopulation.getMin());
        assertTrue(-30.8 == testDoubleDataSetSample.getMin());

        testDoubleDataSetPopulation.addData(dd4);
        testDoubleDataSetSample.addData(dd4);

        assertTrue(-30.8 == testDoubleDataSetPopulation.getMin());
        assertTrue(-30.8 == testDoubleDataSetSample.getMin());
    }

    @Test
    public void testGetStandardDeviation() {
        assertNull(testDoubleDataSetPopulation.getStandardDeviation());
        assertNull(testDoubleDataSetSample.getStandardDeviation());

        DoubleData dd1 = new DoubleData(50.3);
        DoubleData dd2 = new DoubleData(-30.8);
        DoubleData dd3 = new DoubleData(-10.3);

        testDoubleDataSetPopulation.addData(dd1);
        testDoubleDataSetSample.addData(dd1);

        assertTrue(0.0 == testDoubleDataSetPopulation.getStandardDeviation());
        assertTrue(0.0 == testDoubleDataSetSample.getStandardDeviation());

        testDoubleDataSetPopulation.addData(dd2);
        testDoubleDataSetSample.addData(dd2);

        assertTrue(Math.abs(40.55 - testDoubleDataSetPopulation.getStandardDeviation()) < MAX_ACCURACY);
        assertTrue(Math.abs(57.346359954229 - testDoubleDataSetSample.getStandardDeviation()) < MAX_ACCURACY);

        testDoubleDataSetPopulation.addData(dd3);
        testDoubleDataSetSample.addData(dd3);

        assertTrue(Math.abs(34.431606926711 - testDoubleDataSetPopulation.getStandardDeviation()) < MAX_ACCURACY);
        assertTrue(Math.abs(42.169933997261 - testDoubleDataSetSample.getStandardDeviation()) < MAX_ACCURACY);
    }

    @Test
    public void testGetData() {
        assertTrue(testDoubleDataSetPopulation.getData().isEmpty());
        assertTrue(testDoubleDataSetSample.getData().isEmpty());

        DoubleData dd1 = new DoubleData(50.3);
        DoubleData dd2 = new DoubleData(-30.8);

        testDoubleDataSetPopulation.addData(dd1);
        assertTrue(1 == testDoubleDataSetPopulation.getData().size());
        assertTrue(testDoubleDataSetPopulation.getData().contains(dd1));
        testDoubleDataSetSample.addData(dd1);
        assertTrue(1 == testDoubleDataSetSample.getData().size());
        assertTrue(testDoubleDataSetSample.getData().contains(dd1));

        testDoubleDataSetPopulation.addData(dd2);
        assertTrue(2 == testDoubleDataSetPopulation.getData().size());
        assertTrue(testDoubleDataSetPopulation.getData().contains(dd2));
        assertTrue(testDoubleDataSetPopulation.getData().contains(dd1));
        testDoubleDataSetSample.addData(dd2);
        assertTrue(2 == testDoubleDataSetSample.getData().size());
        assertTrue(testDoubleDataSetSample.getData().contains(dd2));
        assertTrue(testDoubleDataSetSample.getData().contains(dd1));
    }

}
