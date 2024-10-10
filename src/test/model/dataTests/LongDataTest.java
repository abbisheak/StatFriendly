package model.dataTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.data.LongData;

public class LongDataTest implements DataTest {
    LongData testLargeLongData;
    LongData testSmallLongData;

    @BeforeEach
    public void runBefore() {
        testLargeLongData = new LongData(30022932132903L);
        testSmallLongData = new LongData(-32L);
    }

    @Test
    public void testConstructor() {
        assertTrue(30022932132903L == testLargeLongData.getData());
        assertTrue(-32L == testSmallLongData.getData());
    }

    @Test
    public void testCompareDataValue() {
        assertTrue(testLargeLongData.compare(30022932132903L));
        assertTrue(testSmallLongData.compare(-32L));

        assertFalse(testLargeLongData.compare(5023023103021301203L));
        assertFalse(testSmallLongData.compare(-2321L));
    }

    @Test
    public void testCompareDataObject() {
        LongData testTrueCompareLargeData = new LongData(30022932132903L);
        LongData testTrueCompareSmallData = new LongData(-32L);

        assertTrue(testLargeLongData.compare(testTrueCompareLargeData));
        assertTrue(testSmallLongData.compare(testTrueCompareSmallData));

        LongData testFalseCompareData = new LongData(5000000L);

        assertFalse(testLargeLongData.compare(testFalseCompareData));
        assertFalse(testSmallLongData.compare(testFalseCompareData));
    }

    @Test
    public void testSetData() {
        assertTrue(30022932132903L == testLargeLongData.getData());
        assertTrue(-32L == testSmallLongData.getData());

        testLargeLongData.setData(-983423434982L);
        testSmallLongData.setData(932L);

        assertTrue(-983423434982L == testLargeLongData.getData());
        assertTrue(932L == testSmallLongData.getData());
    }

    @Test
    public void testGetData() {
        assertTrue(30022932132903L == testLargeLongData.getData());
        assertTrue(-32L == testSmallLongData.getData());
    }

}
