package model.dataspace;

import model.data.DoubleData;
import model.dataset.DoubleDataSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDataVector {
    private DataVector testDV;
    private DoubleDataSet testDds;

    @BeforeEach
    public void runBefore(){
        testDds = new DoubleDataSet(true);

        for(int i = 0; i < 7; i++){
            testDds.addData(new DoubleData(i * 1.0));
        }

        testDV = new DataVector("A", testDds);
        
    }

    @Test
    public void testConstructor(){
        assertEquals("A", testDV.getName());
        assertEquals(testDds, testDV.getDataSet());
    }
}
