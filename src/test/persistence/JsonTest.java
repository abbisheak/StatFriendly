package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

import model.dataset.DoubleDataSet;
import model.data.DoubleData;
import model.dataspace.DataVector;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonTest {
    
    protected void checkDataVector(String name, DoubleDataSet dataSet, DataVector dataVector) {
        assertEquals(name, dataVector.getName());

        DoubleDataSet dataVectorDataSet = dataVector.getDataSet();
        assertTrue(dataSet.size() == dataVectorDataSet.size());
        List<Double> dataNeeded = convertDataToDouble(dataSet.getData());
        List<Double> dataReceived = convertDataToDouble(dataVectorDataSet.getData());

        for(int i = 0; i < dataNeeded.size(); i++){
            assertTrue(dataReceived.contains(dataNeeded.get(i)));
            dataReceived.remove(dataReceived.indexOf(dataNeeded.get(i)));
        }
        assertTrue(dataReceived.isEmpty());
    }

    private List<Double> convertDataToDouble(HashSet<DoubleData> dataSet){
        List<Double> conversion = new ArrayList<>();

        for(DoubleData data : dataSet){
            conversion.add(data.getData());
        }

        return conversion;
    }

}
