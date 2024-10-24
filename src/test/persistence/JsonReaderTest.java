package persistence;

import model.data.DoubleData;
import model.dataset.DoubleDataSet;
import model.dataspace.*;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

public class JsonReaderTest extends JsonTest {
    DoubleDataSet testDds1;
    DoubleDataSet testDds2;
    DoubleDataSet testDds3;

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/dne.json");
        try {
            DataSpace dataSpace = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyDataSpace() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyDataSpace.json");
        try {
            DataSpace dataSpace = reader.read();
            assertEquals("Data space 0", dataSpace.getName());
            assertEquals(0, dataSpace.numDataVectors());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderSinlgeDataVectorDataSpace() {
        JsonReader reader = new JsonReader("./data/testReaderSingleDataVectorDataSpace.json");
        fillDataSets();
        try {
            DataSpace dataSpace = reader.read();
            assertEquals("Data space 1", dataSpace.getName());
            List<DataVector> dataVectors = dataSpace.getDataVectors();
            assertEquals(1, dataVectors.size());
            checkDataVector("Snowy Days", testDds1 , dataVectors.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderMultipleDataVectorsDataSpace() {
        JsonReader reader = new JsonReader("./data/testReaderMultipleDataVectorsDataSpace.json");
        fillDataSets();
        try {
            DataSpace dataSpace = reader.read();
            assertEquals("Data space 2", dataSpace.getName());
            List<DataVector> dataVectors = dataSpace.getDataVectors();
            assertEquals(3, dataVectors.size());
            checkDataVector("Snowy Days", testDds1 , dataVectors.get(0));
            checkDataVector("Rainy Days", testDds2 , dataVectors.get(1));
            checkDataVector("Sunny Days", testDds3 , dataVectors.get(2));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    private void fillDataSets(){
        testDds1 = new DoubleDataSet(true);
        testDds2 = new DoubleDataSet(false);
        testDds3 = new DoubleDataSet(true);
        for(int i = 0; i < 7; i++){
            if(i < 2){
                testDds2.addData(new DoubleData(i*2.0));
            }
            if(i < 5){
                testDds1.addData((new DoubleData(i*1.0)));
            }
            testDds3.addData(new DoubleData(i*3.0));
        }
    }

}
