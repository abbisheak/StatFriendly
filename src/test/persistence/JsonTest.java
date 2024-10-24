package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.dataset.DoubleDataSet;
import model.dataspace.DataVector;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonTest {
    
    protected void checkDataVector(String name, DoubleDataSet dataSet, DataVector dataVector) {
        assertEquals(name, dataVector.getName());
        assertEquals(dataSet, dataVector.getDataSet());
    }

}
