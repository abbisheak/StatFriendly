package model.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class DoubleDataTest implements DataTest {
    DoubleData testLargeDoubleData;
    DoubleData testSmallDoubleData;

    @BeforeEach
    public void runBefore() {
        testLargeDoubleData = new DoubleData(398721321.3389120984);
        testSmallDoubleData = new DoubleData(-213.23);
    }

    @Test
    public void testConstructor() {
        assertTrue(testLargeDoubleData.compare(398721321.3389120984));
        assertTrue(testSmallDoubleData.compare(-213.23));
    }

    @Test
    public void testCompareDataValue() {
        assertTrue(testLargeDoubleData.compare(398721321.3389120984));
        assertTrue(testSmallDoubleData.compare(-213.23));

        testLargeDoubleData.setData(-21380213123.77777777);
        testSmallDoubleData.setData(9831.12);

        assertFalse(testLargeDoubleData.compare(21380213123.77777777));
        assertFalse(testSmallDoubleData.compare(-9831.12));
    }

    @Test
    public void testCompareDataValueDifferenceInRange() {
        assertTrue(testLargeDoubleData.compare(398721321.3389120984));
        assertTrue(testSmallDoubleData.compare(-213.23));

        assertTrue(testLargeDoubleData.compare(398721321.3389130984));
        assertTrue(testSmallDoubleData.compare(-213.230001));
    }

    @Test
    public void testCompareDataValueDifferenceOutOfRange() {
        assertTrue(testLargeDoubleData.compare(398721321.3389120984));
        assertTrue(testSmallDoubleData.compare(-213.23));

        assertFalse(testLargeDoubleData.compare(398721321.33893));
        assertFalse(testSmallDoubleData.compare(-213.23002));
    }

    @Test
    public void testCompareDataObject() {
        assertTrue(testLargeDoubleData.compare(398721321.338912));
        assertTrue(testSmallDoubleData.compare(-213.23));

        DoubleData compareLargeDoubleData = new DoubleData(398721321.3389120984);
        DoubleData compareSmallDoubleData = new DoubleData(-213.23);

        assertTrue(testLargeDoubleData.compare(compareLargeDoubleData));
        assertTrue(testSmallDoubleData.compare(compareSmallDoubleData));

        compareLargeDoubleData.setData(398217398.3982173812);
        compareSmallDoubleData.setData(3298.11);

        assertFalse(testLargeDoubleData.compare(compareLargeDoubleData));
        assertFalse(testSmallDoubleData.compare(compareSmallDoubleData));
    }

    @Test
    public void testSetData() {
        assertTrue(testLargeDoubleData.compare(398721321.3389120984));
        assertTrue(testSmallDoubleData.compare(-213.23));

        testLargeDoubleData.setData(3827490183.37218);
        testSmallDoubleData.setData(982.123);

        assertTrue(testLargeDoubleData.compare(3827490183.37218));
        assertTrue(testSmallDoubleData.compare(982.123));
    }

    @Test
    public void testGetData() {
        assertTrue(398721321.3389120984 == testLargeDoubleData.getData());
        assertTrue(-213.23 == testSmallDoubleData.getData());
    }

}
