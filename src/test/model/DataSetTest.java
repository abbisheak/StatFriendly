package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.data.DoubleData;
import model.data.LongData;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashSet;
import java.util.Iterator;

public class DataSetTest{
    private static final Double DOUBLE_MAX_ACCURACY = 0.00001;

    DataSet<Long, LongData> testLongSampleDataSet;
    DataSet<Double, DoubleData> testDoublePopulationDataSet;

    @BeforeEach
    public void runBefore() {
        testLongSampleDataSet = new DataSet<>(true);
        testDoublePopulationDataSet = new DataSet<>(false);
    }

    @Test
    public void testConstructor() {
        initializedProperly();
    }

    @Test
    public void testAddSingleData() {
        initializedProperly();

        DoubleData dd1 = new DoubleData(-231.3812);
        LongData ld1 = new LongData(30L);

        testLongSampleDataSet.addData(ld1);
        testDoublePopulationDataSet.addData(dd1);

        assertTrue(testLongSampleDataSet.contains(ld1));
        assertTrue(testDoublePopulationDataSet.contains(dd1));
    }

    @Test
    public void testAddMultipleData() {
        initializedProperly();

        DoubleData dd1 = new DoubleData(-231.3812);
        DoubleData dd2 = new DoubleData(3293123.213);
        DoubleData dd3 = new DoubleData(3984328.231);

        testDoublePopulationDataSet.addData(dd1);
        testDoublePopulationDataSet.addData(dd2);
        testDoublePopulationDataSet.addData(dd3);

        assertTrue(testDoublePopulationDataSet.contains(dd1));
        assertTrue(testDoublePopulationDataSet.contains(dd2));
        assertTrue(testDoublePopulationDataSet.contains(dd3));
    }

    @Test
    public void testAddDataDuplicate() {
        initializedProperly();

        DoubleData dd1 = new DoubleData(-231.3812);
        DoubleData dd2 = new DoubleData(3293123.213);

        testDoublePopulationDataSet.addData(dd1);
        assertTrue(1 == testDoublePopulationDataSet.size());
        testDoublePopulationDataSet.addData(dd1);
        assertTrue(1 == testDoublePopulationDataSet.size());

        testDoublePopulationDataSet.addData(dd2);
        assertTrue(2 == testDoublePopulationDataSet.size());
        testDoublePopulationDataSet.addData(dd1);
        assertTrue(2 == testDoublePopulationDataSet.size());
    }

    @Test
    public void testRemoveSingleData() {
        initializedProperly();

        DoubleData dd1 = new DoubleData(-231.3812);
        LongData ld1 = new LongData(30L);

        testLongSampleDataSet.addData(ld1);
        testDoublePopulationDataSet.addData(dd1);

        assertTrue(testLongSampleDataSet.contains(ld1));
        assertTrue(testDoublePopulationDataSet.contains(dd1));

        testLongSampleDataSet.removeData(ld1);
        testDoublePopulationDataSet.removeData(dd1);

        assertFalse(testLongSampleDataSet.contains(ld1));
        assertFalse(testDoublePopulationDataSet.contains(dd1));
    }

    @Test
    public void testRemoveMultipleData() {
        initializedProperly();

        DoubleData dd1 = new DoubleData(-231.3812);
        DoubleData dd2 = new DoubleData(3293123.213);
        DoubleData dd3 = new DoubleData(3984328.231);

        testDoublePopulationDataSet.addData(dd1);
        testDoublePopulationDataSet.addData(dd2);
        testDoublePopulationDataSet.addData(dd3);

        assertTrue(testDoublePopulationDataSet.contains(dd1));
        assertTrue(testDoublePopulationDataSet.contains(dd2));
        assertTrue(testDoublePopulationDataSet.contains(dd3));

        testDoublePopulationDataSet.removeData(dd1);

        assertFalse(testDoublePopulationDataSet.contains(dd1));
        assertTrue(testDoublePopulationDataSet.contains(dd2));
        assertTrue(testDoublePopulationDataSet.contains(dd3));

        testDoublePopulationDataSet.removeData(dd2);

        assertFalse(testDoublePopulationDataSet.contains(dd1));
        assertFalse(testDoublePopulationDataSet.contains(dd2));
        assertTrue(testDoublePopulationDataSet.contains(dd3));

        testDoublePopulationDataSet.removeData(dd3);

        assertTrue(testDoublePopulationDataSet.getData().isEmpty());
    }

    @Test
    public void testContains() {
        initializedProperly();

        DoubleData dd1 = new DoubleData(-231.3812);
        DoubleData dd2 = new DoubleData(3293123.213);
        assertFalse(testDoublePopulationDataSet.contains(dd1));

        testDoublePopulationDataSet.addData(dd1);
        assertTrue(testDoublePopulationDataSet.contains(dd1));
        assertFalse(testDoublePopulationDataSet.contains(dd2));

        testDoublePopulationDataSet.addData(dd2);
        assertTrue(testDoublePopulationDataSet.contains(dd2));

    }

    @Test
    public void testClear() {
        initializedProperly();

        LongData ld1 = new LongData(10L);
        LongData ld2 = new LongData(-320L);

        testLongSampleDataSet.addData(ld1);
        assertFalse(testLongSampleDataSet.getData().isEmpty());
        assertTrue(testLongSampleDataSet.contains(ld1));

        testLongSampleDataSet.clear();
        assertTrue(testLongSampleDataSet.getData().isEmpty());
        assertFalse(testLongSampleDataSet.contains(ld1));

        testLongSampleDataSet.addData(ld1);
        testLongSampleDataSet.addData(ld2);

        assertFalse(testLongSampleDataSet.getData().isEmpty());
        assertTrue(testLongSampleDataSet.contains(ld1));
        assertTrue(testLongSampleDataSet.contains(ld2));

        testLongSampleDataSet.clear();
        assertTrue(testLongSampleDataSet.getData().isEmpty());
        assertFalse(testLongSampleDataSet.contains(ld1));
        assertFalse(testLongSampleDataSet.contains(ld2));
    }

    @Test
    public void testIterator() {
        initializedProperly();
        assertFalse(testDoublePopulationDataSet.iterator().hasNext());

        DoubleData dd1 = new DoubleData(-231.3812);
        DoubleData dd2 = new DoubleData(3293123.213);

        testDoublePopulationDataSet.addData(dd1);
        assertTrue(testDoublePopulationDataSet.iterator().hasNext());

        testDoublePopulationDataSet.addData(dd2);
        Iterator<DoubleData> testIterator = testDoublePopulationDataSet.iterator();
        for (int i = 0; i < 2; i++) {
            assertTrue(testIterator.hasNext());
            assertTrue(testDoublePopulationDataSet.contains(testIterator.next()));
        }
    }

    @Test
    public void testSize() {
        initializedProperly();
        assertTrue(0 == testLongSampleDataSet.size());

        LongData ld1 = new LongData(90L);
        testLongSampleDataSet.addData(ld1);
        assertTrue(1 == testLongSampleDataSet.size());

        LongData ld2 = new LongData(-232L);
        testLongSampleDataSet.addData(ld2);
        assertTrue(2 == testLongSampleDataSet.size());
    }

    @Test
    public void testIsSample() {
        assertFalse(testDoublePopulationDataSet.isSample());
        assertTrue(testLongSampleDataSet.isSample());
    }

    @Test
    public void testGetMean() {
        initializedProperly();

        DoubleData dd1 = new DoubleData(-231.3812);
        testDoublePopulationDataSet.addData(dd1);
        assertTrue(Math.abs(-231.3812 - testDoublePopulationDataSet.getMean()) < DOUBLE_MAX_ACCURACY);

        DoubleData dd2 = new DoubleData(3293123.213);
        testDoublePopulationDataSet.addData(dd2);
        assertTrue(Math.abs(1646445.91959 - testDoublePopulationDataSet.getMean()) < DOUBLE_MAX_ACCURACY);
    }

    @Test
    public void testGetMedian() {
        initializedProperly();

        DoubleData dd1 = new DoubleData(-231.3812);
        testDoublePopulationDataSet.addData(dd1);
        assertTrue(-231.3812 == testDoublePopulationDataSet.getMedian());

        DoubleData dd2 = new DoubleData(3293123.213);
        testDoublePopulationDataSet.addData(dd2);
        assertTrue(-231.3812 == testDoublePopulationDataSet.getMedian());

        DoubleData dd3 = new DoubleData(999239.213);
        testDoublePopulationDataSet.addData(dd3);
        assertTrue(999239.213 == testDoublePopulationDataSet.getMedian());
    }

    @Test
    public void testGetMode() {
        initializedProperly();

        DoubleData dd1 = new DoubleData(-231.3812);
        testDoublePopulationDataSet.addData(dd1);
        assertTrue(-231.3812 == testDoublePopulationDataSet.getMode());

        DoubleData dd2 = new DoubleData(3293123.213);
        testDoublePopulationDataSet.addData(dd2);
        assertTrue(3293123.213 == testDoublePopulationDataSet.getMode());

        DoubleData dd3 = new DoubleData(-231.3812);
        testDoublePopulationDataSet.addData(dd3);
        assertTrue(-231.3812 == testDoublePopulationDataSet.getMode());
    }

    @Test
    public void testGetMax() {
        initializedProperly();

        DoubleData dd1 = new DoubleData(-231.3812);
        testDoublePopulationDataSet.addData(dd1);
        assertTrue(-231.3812 == testDoublePopulationDataSet.getMax());

        DoubleData dd2 = new DoubleData(3293123.213);
        testDoublePopulationDataSet.addData(dd2);
        assertTrue(3293123.213 == testDoublePopulationDataSet.getMax());

        DoubleData dd3 = new DoubleData(999239.213);
        testDoublePopulationDataSet.addData(dd3);
        assertTrue(3293123.213 == testDoublePopulationDataSet.getMax());
    }

    @Test
    public void testGetMin() {
        initializedProperly();

        DoubleData dd1 = new DoubleData(-231.3812);
        testDoublePopulationDataSet.addData(dd1);
        assertTrue(-231.3812 == testDoublePopulationDataSet.getMin());

        DoubleData dd2 = new DoubleData(3293123.213);
        testDoublePopulationDataSet.addData(dd2);
        assertTrue(-231.3812 == testDoublePopulationDataSet.getMin());

        DoubleData dd3 = new DoubleData(-287132819.213);
        testDoublePopulationDataSet.addData(dd3);
        assertTrue(-287132819.213 == testDoublePopulationDataSet.getMin());
    }

    @Test
    public void testGetStandardDeviation() {
        initializedProperly();

        DoubleData dd1 = new DoubleData(-231.3812);
        testDoublePopulationDataSet.addData(dd1);
        assertTrue(0.0 == testDoublePopulationDataSet.getStandardDeviation());

        LongData ld1 = new LongData(82312L);
        testLongSampleDataSet.addData(ld1);
        assertTrue(0.0 == testLongSampleDataSet.getStandardDeviation());

        DoubleData dd2 = new DoubleData(500.35);
        testDoublePopulationDataSet.addData(dd2);
        assertTrue(Math.abs(365.8656 - testDoublePopulationDataSet.getStandardDeviation()) < DOUBLE_MAX_ACCURACY);

        LongData ld2 = new LongData(3123L);
        testLongSampleDataSet.addData(ld2);
        assertTrue(Math.abs(39594.5 - testLongSampleDataSet.getStandardDeviation()) < DOUBLE_MAX_ACCURACY);
    }

    @Test
    public void testGetData() {
        initializedProperly();

        HashSet<DoubleData> testHashSet = new HashSet<>();
        DoubleData dd1 = new DoubleData(-231.3812);
        DoubleData dd2 = new DoubleData(3293123.213);

        testDoublePopulationDataSet.addData(dd1);
        testHashSet.add(dd1);
        assertEquals(testHashSet, testDoublePopulationDataSet.getData());

        testDoublePopulationDataSet.addData(dd2);
        testHashSet.add(dd2);
        assertEquals(testHashSet, testDoublePopulationDataSet.getData());
    }

    public void initializedProperly() {
        assertTrue(testLongSampleDataSet.isSample());
        assertFalse(testDoublePopulationDataSet.isSample());

        assertTrue(testDoublePopulationDataSet.getData().isEmpty());
        assertTrue(testLongSampleDataSet.getData().isEmpty());
    }
}
