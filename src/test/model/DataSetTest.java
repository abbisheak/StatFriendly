package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DataSet;
import model.data.DoubleData;
import model.data.LongData;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public interface DataSetTest {

    @BeforeEach
    public void runBefore();

    @Test
    public void testConstructor();

    @Test
    public void testAddSingleData();

    @Test
    public void testAddMultipleData();

    @Test
    public void testRemoveSingleData();

    @Test
    public void testRemoveMultipleData();

    @Test
    public void testContains();

    @Test
    public void testClear();

    @Test
    public void testIterator();

    @Test
    public void testIsSample();

    @Test
    public void testGetMean();

    @Test
    public void testGetMedian();

    @Test
    public void testGetMode();

    @Test
    public void testGetMax();

    @Test
    public void testGetMin();

    @Test
    public void testGetStandardDeviation();

    @Test
    public void testGetData();

}
