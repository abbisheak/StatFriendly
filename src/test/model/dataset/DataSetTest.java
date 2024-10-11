package model.dataset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public interface DataSetTest {

    @BeforeEach
    public void runBefore();

    @Test
    public void testConstructor();

    @Test
    public void testAddDataOnce();

    @Test
    public void testAddDataMultipleTimes();

    @Test
    public void testAddDataFail();

    @Test
    public void testRemoveDataOnce();

    @Test
    public void testRemoveDataMultipleTimes();

    @Test
    public void testRemoveDataNotInSet();

    @Test
    public void testContains();

    @Test
    public void testClear();

    @Test
    public void testIterator();

    @Test
    public void testSize();

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