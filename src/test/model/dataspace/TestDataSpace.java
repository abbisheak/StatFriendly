package model.dataspace;


import model.data.DoubleData;
import model.dataset.DoubleDataSet;

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
    public void runBefore(){
        dv1 = new DataVector("1", new DoubleDataSet(false));
        dv2 = new DataVector("2", new DoubleDataSet(false));
        dv3 = new DataVector("3", new DoubleDataSet(false));
        testDataSpace = new DataSpace("Test");
        testDataSpace.addDataVector(dv1);
        testDataSpace.addDataVector(dv2);
        testDataSpace.addDataVector(dv3);
    }

    @Test
    public void testGetDataVector(){
        assertEquals(dv1, testDataSpace.getDataVector("1"));
        assertEquals(dv2, testDataSpace.getDataVector("2"));
        assertEquals(dv3, testDataSpace.getDataVector("3"));
        assertNull(testDataSpace.getDataVector("4"));
    }
}
