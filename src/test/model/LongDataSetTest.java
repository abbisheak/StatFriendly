package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.data.LongData;

import java.util.Iterator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class LongDataSetTest implements DataSetTest {
    private static final Double MAX_ACCURACY = 0.00001;

    LongDataSet testLongDataSetSample;
    LongDataSet testLongDataSetPopulation;

    @BeforeEach
    public void runBefore() {
        testLongDataSetSample = new LongDataSet(true);
        testLongDataSetPopulation = new LongDataSet(false);
    }

    @Test
    public void testConstructor() {
        assertTrue(testLongDataSetSample.isSample());
        assertFalse(testLongDataSetPopulation.isSample());

        assertTrue(testLongDataSetSample.getData().isEmpty());
        assertTrue(testLongDataSetPopulation.getData().isEmpty());
    }

    @Test
    public void testAddDataOnce() {
        assertTrue(testLongDataSetPopulation.getData().isEmpty());
        assertTrue(testLongDataSetSample.getData().isEmpty());

        LongData ld1 = new LongData(321L);

        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);

        assertTrue(1 == testLongDataSetPopulation.size());
        assertTrue(1 == testLongDataSetSample.size());
    }

    @Test
    public void testAddDataMultipleTimes() {
        LongData ld1 = new LongData(10L);
        LongData ld2 = new LongData(-213919L);
        LongData ld3 = new LongData(3219399L);

        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);

        assertTrue(1 == testLongDataSetPopulation.size());
        assertTrue(1 == testLongDataSetSample.size());

        testLongDataSetPopulation.addData(ld2);
        testLongDataSetSample.addData(ld2);

        assertTrue(2 == testLongDataSetPopulation.size());
        assertTrue(2 == testLongDataSetSample.size());

        testLongDataSetPopulation.addData(ld3);
        testLongDataSetSample.addData(ld3);

        assertTrue(3 == testLongDataSetPopulation.size());
        assertTrue(3 == testLongDataSetSample.size());
    }

    @Test
    public void testAddDataFail() {
        LongData ld1 = null;

        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);

        assertTrue(0 == testLongDataSetPopulation.size());
        assertTrue(0 == testLongDataSetSample.size());

        ld1 = new LongData(20L);
        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);

        assertTrue(1 == testLongDataSetPopulation.size());
        assertTrue(1 == testLongDataSetSample.size());

        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);

        assertTrue(1 == testLongDataSetPopulation.size());
        assertTrue(1 == testLongDataSetSample.size());
    
    }

    @Test
    public void testRemoveDataOnce() {
        LongData ld1 = new LongData(10L);

        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);

        assertTrue(1 == testLongDataSetPopulation.size());
        assertTrue(1 == testLongDataSetSample.size());

        testLongDataSetPopulation.removeData(ld1);
        testLongDataSetSample.removeData(ld1);

        assertTrue(0 == testLongDataSetPopulation.size());
        assertTrue(0 == testLongDataSetSample.size());
    }

    @Test
    public void testRemoveDataMultipleTimes() {
        LongData ld1 = new LongData(100L);
        LongData ld2 = new LongData(9000L);
        LongData ld3 = new LongData(231L);

        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);
        testLongDataSetPopulation.addData(ld2);
        testLongDataSetSample.addData(ld2);
        testLongDataSetPopulation.addData(ld3);
        testLongDataSetSample.addData(ld3);

        assertTrue(3 == testLongDataSetPopulation.size());
        assertTrue(3 == testLongDataSetSample.size());

        testLongDataSetPopulation.removeData(ld1);
        testLongDataSetSample.removeData(ld1);

        assertTrue(2 == testLongDataSetPopulation.size());
        assertTrue(2 == testLongDataSetSample.size());

        testLongDataSetPopulation.removeData(ld3);
        testLongDataSetSample.removeData(ld3);

        assertTrue(1 == testLongDataSetPopulation.size());
        assertTrue(1 == testLongDataSetSample.size());

        testLongDataSetPopulation.removeData(ld2);
        testLongDataSetSample.removeData(ld2);

        assertTrue(0 == testLongDataSetPopulation.size());
        assertTrue(0 == testLongDataSetSample.size());
    }

    @Test
    public void testRemoveDataNotInSet() {
        assertTrue(0 == testLongDataSetPopulation.size());
        assertTrue(0 == testLongDataSetSample.size());

        testLongDataSetPopulation.removeData(new LongData(100L));
        testLongDataSetSample.removeData(new LongData(-200L));
        assertTrue(0 == testLongDataSetPopulation.size());
        assertTrue(0 == testLongDataSetSample.size());

        LongData ld1 = new LongData(32193L);
        LongData ld2 = new LongData(2391L);
        testLongDataSetPopulation.addData(ld2);
        testLongDataSetSample.addData(ld2);
        assertTrue(1 == testLongDataSetPopulation.size());
        assertTrue(1 == testLongDataSetSample.size());

        testLongDataSetPopulation.removeData(ld1);
        testLongDataSetSample.removeData(ld1);
        assertTrue(1 == testLongDataSetPopulation.size());
        assertTrue(1 == testLongDataSetSample.size());

        testLongDataSetPopulation.removeData(ld2);
        testLongDataSetSample.removeData(ld2);
        assertTrue(0 == testLongDataSetPopulation.size());
        assertTrue(0 == testLongDataSetSample.size());
        testLongDataSetPopulation.removeData(ld2);
        testLongDataSetSample.removeData(ld2);
        assertTrue(0 == testLongDataSetPopulation.size());
        assertTrue(0 == testLongDataSetSample.size());
    }

    @Test
    public void testContains() {
        LongData ld1 = new LongData(8321321L);
        LongData ld2 = new LongData(-2311L);

        assertFalse(testLongDataSetPopulation.contains(ld1));
        assertFalse(testLongDataSetSample.contains(ld1));

        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);
        assertTrue(testLongDataSetPopulation.contains(ld1));
        assertTrue(testLongDataSetSample.contains(ld1));

        assertFalse(testLongDataSetPopulation.contains(ld2));
        assertFalse(testLongDataSetSample.contains(ld2));
    }

    @Test
    public void testClear() {
        assertTrue(testLongDataSetPopulation.getData().isEmpty());
        assertNull(testLongDataSetPopulation.getMax());
        assertNull(testLongDataSetPopulation.getMean());
        assertNull(testLongDataSetPopulation.getMedian());
        assertNull(testLongDataSetPopulation.getMin());
        assertNull(testLongDataSetPopulation.getMode());
        assertNull(testLongDataSetPopulation.getStandardDeviation());

        assertTrue(testLongDataSetSample.getData().isEmpty());
        assertNull(testLongDataSetSample.getMax());
        assertNull(testLongDataSetSample.getMedian());
        assertNull(testLongDataSetSample.getMin());
        assertNull(testLongDataSetSample.getMode());
        assertNull(testLongDataSetSample.getStandardDeviation());

        LongData ld1 = new LongData(232132L);

        testLongDataSetPopulation.addData(ld1);
        assertFalse(testLongDataSetPopulation.getData().isEmpty());
        assertNotEquals(null, testLongDataSetPopulation.getMax());
        assertNotEquals(null, testLongDataSetPopulation.getMean());
        assertNotEquals(null, testLongDataSetPopulation.getMedian());
        assertNotEquals(null, testLongDataSetPopulation.getMin());
        assertNotEquals(null, testLongDataSetPopulation.getMode());
        assertNotEquals(null, testLongDataSetPopulation.getStandardDeviation());

        testLongDataSetSample.addData(ld1);
        assertFalse(testLongDataSetSample.getData().isEmpty());
        assertNotEquals(null, testLongDataSetSample.getMax());
        assertNotEquals(null, testLongDataSetSample.getMean());
        assertNotEquals(null, testLongDataSetSample.getMedian());
        assertNotEquals(null, testLongDataSetSample.getMin());
        assertNotEquals(null, testLongDataSetSample.getMode());
        assertNotEquals(null, testLongDataSetSample.getStandardDeviation());

        testLongDataSetPopulation.clear();
        assertTrue(testLongDataSetPopulation.getData().isEmpty());
        assertNull(testLongDataSetPopulation.getMax());
        assertNull(testLongDataSetPopulation.getMean());
        assertNull(testLongDataSetPopulation.getMedian());
        assertNull(testLongDataSetPopulation.getMin());
        assertNull(testLongDataSetPopulation.getMode());
        assertNull(testLongDataSetPopulation.getStandardDeviation());

        testLongDataSetSample.clear();
        assertTrue(testLongDataSetSample.getData().isEmpty());
        assertNull(testLongDataSetSample.getMax());
        assertNull(testLongDataSetSample.getMedian());
        assertNull(testLongDataSetSample.getMin());
        assertNull(testLongDataSetSample.getMode());
        assertNull(testLongDataSetSample.getStandardDeviation());
    }

    @Test
    public void testIterator() {
        assertFalse(testLongDataSetPopulation.iterator().hasNext());
        assertFalse(testLongDataSetSample.iterator().hasNext());

        LongData ld1 = new LongData(-3213L);
        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);

        Iterator<LongData> populationIterator = testLongDataSetPopulation.iterator();
        Iterator<LongData> sampleIterator = testLongDataSetSample.iterator();

        assertTrue(populationIterator.hasNext());
        assertTrue(sampleIterator.hasNext());

        assertEquals(ld1, populationIterator.next());
        assertEquals(ld1, sampleIterator.next());

        assertFalse(populationIterator.hasNext());
        assertFalse(sampleIterator.hasNext());
    }

    @Test
    public void testSize() {
        assertTrue(0 == testLongDataSetPopulation.size());
        assertTrue(0 == testLongDataSetSample.size());

        LongData ld1 = new LongData(32131L);
        LongData ld2 = new LongData(-3123331L);

        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);
        assertTrue(1 == testLongDataSetPopulation.size());
        assertTrue(1 == testLongDataSetSample.size());

        testLongDataSetPopulation.addData(ld2);
        testLongDataSetSample.addData(ld2);
        assertTrue(2 == testLongDataSetPopulation.size());
        assertTrue(2 == testLongDataSetSample.size());
    }

    @Test
    public void testIsSample() {
        assertTrue(testLongDataSetSample.isSample());
        assertFalse(testLongDataSetPopulation.isSample());
    }

    @Test
    public void testGetMean() {
        assertNull(testLongDataSetPopulation.getMean());
        assertNull(testLongDataSetSample.getMean());

        LongData ld1 = new LongData(231231L);
        LongData ld2 = new LongData(-3103123L);
        LongData ld3 = new LongData(5L);

        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);

        assertTrue(231231.0 == testLongDataSetPopulation.getMean());
        assertTrue(231231.0 == testLongDataSetSample.getMean());

        testLongDataSetPopulation.addData(ld2);
        testLongDataSetSample.addData(ld2);

        assertTrue(-1435946.0 == testLongDataSetPopulation.getMean());
        assertTrue(-1435946.0 == testLongDataSetSample.getMean());

        testLongDataSetPopulation.addData(ld3);
        testLongDataSetSample.addData(ld3);

        assertTrue(Math.abs(-574377.4 - testLongDataSetPopulation.getMean()) < MAX_ACCURACY);
        assertTrue(Math.abs(-574377.4 - testLongDataSetSample.getMean()) < MAX_ACCURACY);
    }

    @Test
    public void testGetMedian() {

        assertNull(testLongDataSetPopulation.getMedian());
        assertNull(testLongDataSetSample.getMedian());

        LongData ld1 = new LongData(50L);
        LongData ld2 = new LongData(-30L);
        LongData ld3 = new LongData(10L);
        LongData ld4 = new LongData(40L);

        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);

        assertTrue(50L == testLongDataSetPopulation.getMedian());
        assertTrue(50L == testLongDataSetSample.getMedian());

        testLongDataSetPopulation.addData(ld2);
        testLongDataSetSample.addData(ld2);

        assertTrue(-30L == testLongDataSetPopulation.getMedian());
        assertTrue(-30L == testLongDataSetSample.getMedian());

        testLongDataSetPopulation.addData(ld3);
        testLongDataSetSample.addData(ld3);

        assertTrue(10L == testLongDataSetPopulation.getMedian());
        assertTrue(10L == testLongDataSetSample.getMedian());

        testLongDataSetPopulation.addData(ld4);
        testLongDataSetSample.addData(ld4);

        assertTrue(10L == testLongDataSetPopulation.getMedian());
        assertTrue(10L == testLongDataSetSample.getMedian());
    }

    @Test
    public void testGetMode() {

        assertNull(testLongDataSetPopulation.getMode());
        assertNull(testLongDataSetSample.getMode());

        LongData ld1 = new LongData(50L);
        LongData ld2 = new LongData(-30L);
        LongData ld3 = new LongData(50L);
        LongData ld4 = new LongData(50L);
        LongData ld5 = new LongData(-30L);

        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);

        assertTrue(50L == testLongDataSetPopulation.getMode());
        assertTrue(50L == testLongDataSetSample.getMode());

        testLongDataSetPopulation.addData(ld2);
        testLongDataSetSample.addData(ld2);

        assertTrue(-30L == testLongDataSetPopulation.getMode());
        assertTrue(-30L == testLongDataSetSample.getMode());

        testLongDataSetPopulation.addData(ld3);
        testLongDataSetSample.addData(ld3);

        assertTrue(50L == testLongDataSetPopulation.getMode());
        assertTrue(50L == testLongDataSetSample.getMode());

        testLongDataSetPopulation.addData(ld4);
        testLongDataSetSample.addData(ld4);

        assertTrue(50L == testLongDataSetPopulation.getMode());
        assertTrue(50L == testLongDataSetSample.getMode());

        testLongDataSetPopulation.addData(ld5);
        testLongDataSetSample.addData(ld5);

        assertTrue(50L == testLongDataSetPopulation.getMode());
        assertTrue(50L == testLongDataSetSample.getMode());
    }

    @Test
    public void testGetMax() {
        assertNull(testLongDataSetPopulation.getMax());
        assertNull(testLongDataSetSample.getMax());

        LongData ld1 = new LongData(50L);
        LongData ld2 = new LongData(-30L);
        LongData ld3 = new LongData(10L);
        LongData ld4 = new LongData(50L);

        testLongDataSetPopulation.addData(ld2);
        testLongDataSetSample.addData(ld2);

        assertTrue(-30L == testLongDataSetPopulation.getMax());
        assertTrue(-30L == testLongDataSetSample.getMax());

        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);

        assertTrue(50L == testLongDataSetPopulation.getMax());
        assertTrue(50L == testLongDataSetSample.getMax());

        testLongDataSetPopulation.addData(ld3);
        testLongDataSetSample.addData(ld3);

        assertTrue(50L == testLongDataSetPopulation.getMax());
        assertTrue(50L == testLongDataSetSample.getMax());

        testLongDataSetPopulation.addData(ld4);
        testLongDataSetSample.addData(ld4);

        assertTrue(50L == testLongDataSetPopulation.getMax());
        assertTrue(50L == testLongDataSetSample.getMax());
    }

    @Test
    public void testGetMin() {
        assertNull(testLongDataSetPopulation.getMin());
        assertNull(testLongDataSetSample.getMin());

        LongData ld1 = new LongData(50L);
        LongData ld2 = new LongData(-30L);
        LongData ld3 = new LongData(-10L);
        LongData ld4 = new LongData(-30L);

        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);

        assertTrue(50L == testLongDataSetPopulation.getMin());
        assertTrue(50L == testLongDataSetSample.getMin());

        testLongDataSetPopulation.addData(ld2);
        testLongDataSetSample.addData(ld2);

        assertTrue(-30L == testLongDataSetPopulation.getMin());
        assertTrue(-30L == testLongDataSetSample.getMin());

        testLongDataSetPopulation.addData(ld3);
        testLongDataSetSample.addData(ld3);

        assertTrue(-30L == testLongDataSetPopulation.getMin());
        assertTrue(-30L == testLongDataSetSample.getMin());

        testLongDataSetPopulation.addData(ld4);
        testLongDataSetSample.addData(ld4);

        assertTrue(-30L == testLongDataSetPopulation.getMin());
        assertTrue(-30L == testLongDataSetSample.getMin());
    }

    @Test
    public void testGetStandardDeviation() {
        assertNull(testLongDataSetPopulation.getStandardDeviation());
        assertNull(testLongDataSetSample.getStandardDeviation());

        LongData ld1 = new LongData(50L);
        LongData ld2 = new LongData(-30L);
        LongData ld3 = new LongData(-10L);

        testLongDataSetPopulation.addData(ld1);
        testLongDataSetSample.addData(ld1);

        assertTrue(0.0 == testLongDataSetPopulation.getStandardDeviation());
        assertTrue(0.0 == testLongDataSetSample.getStandardDeviation());

        testLongDataSetPopulation.addData(ld2);
        testLongDataSetSample.addData(ld2);

        assertTrue(Math.abs(40.0 - testLongDataSetPopulation.getStandardDeviation()) < MAX_ACCURACY);
        assertTrue(Math.abs(56.568542494924 - testLongDataSetSample.getStandardDeviation()) < MAX_ACCURACY);

        testLongDataSetPopulation.addData(ld3);
        testLongDataSetSample.addData(ld3);

        assertTrue(Math.abs(33.993463423952 - testLongDataSetPopulation.getStandardDeviation()) < MAX_ACCURACY);
        assertTrue(Math.abs(41.633319989323 - testLongDataSetSample.getStandardDeviation()) < MAX_ACCURACY);
    }

    @Test
    public void testGetData() {
        assertTrue(testLongDataSetPopulation.getData().isEmpty());
        assertTrue(testLongDataSetSample.getData().isEmpty());

        LongData ld1 = new LongData(50L);
        LongData ld2 = new LongData(-30L);

        testLongDataSetPopulation.addData(ld1);
        assertTrue(1 == testLongDataSetPopulation.getData().size());
        assertTrue(testLongDataSetPopulation.getData().contains(ld1));
        testLongDataSetSample.addData(ld1);
        assertTrue(1 == testLongDataSetSample.getData().size());
        assertTrue(testLongDataSetSample.getData().contains(ld1));

        testLongDataSetPopulation.addData(ld2);
        assertTrue(2 == testLongDataSetPopulation.getData().size());
        assertTrue(testLongDataSetPopulation.getData().contains(ld2));
        assertTrue(testLongDataSetPopulation.getData().contains(ld1));
        testLongDataSetSample.addData(ld2);
        assertTrue(2 == testLongDataSetSample.getData().size());
        assertTrue(testLongDataSetSample.getData().contains(ld2));
        assertTrue(testLongDataSetSample.getData().contains(ld1));
    }
    
}
