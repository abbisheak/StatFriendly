package model.dataspace;

import model.dataset.DoubleDataSet;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDataSpace {
    DataSpace testDataSpace;
    DataVector dv1;
    DataVector dv2;
    DataVector dv3;

    @BeforeEach
    public void runBefore() {
        dv1 = new DataVector("1", new DoubleDataSet(false));
        dv2 = new DataVector("2", new DoubleDataSet(false));
        dv3 = new DataVector("3", new DoubleDataSet(false));
        testDataSpace = new DataSpace("Test");
    }

    @Test
    public void testGetDataVector() {
        testDataSpace.addDataVector(dv1);
        testDataSpace.addDataVector(dv2);
        testDataSpace.addDataVector(dv3);

        assertEquals(dv1, testDataSpace.getDataVector("1"));
        assertEquals(dv2, testDataSpace.getDataVector("2"));
        assertEquals(dv3, testDataSpace.getDataVector("3"));
        assertNull(testDataSpace.getDataVector("4"));
    }

    @Test
    public void testGetNames() {

        assertEquals(new ArrayList<>(), testDataSpace.getNames());

        testDataSpace.addDataVector(dv1);
        testDataSpace.addDataVector(dv2);
        testDataSpace.addDataVector(dv3);
        List<String> testList = new ArrayList<>();
        testList.add("1");
        testList.add("2");
        testList.add("3");
        assertEquals(testList, testDataSpace.getNames());

    }
}
