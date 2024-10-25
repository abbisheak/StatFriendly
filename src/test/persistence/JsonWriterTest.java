package persistence;

import model.data.DoubleData;
import model.dataset.DoubleDataSet;
import model.dataspace.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonWriterTest extends JsonTest {
    DoubleDataSet testDds1;
    DoubleDataSet testDds2;
    DoubleDataSet testDds3;

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyDataSpace() {
        try {
            DataSpace dataSpace = new DataSpace("Data space 3");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyDataSpace.json");
            writer.open();
            writer.write(dataSpace);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyDataSpace.json");
            dataSpace = reader.read();
            assertEquals("Data space 3", dataSpace.getName());
            assertEquals(0, dataSpace.numDataVectors());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterFilledDataSpace() {
        fillDataSets();
        try {
            DataSpace dataSpace = new DataSpace("Data space 4");
            dataSpace.addDataVector(new DataVector("population", testDds1));
            dataSpace.addDataVector(new DataVector("fires", testDds2));
            dataSpace.addDataVector(new DataVector("floods", testDds3));
            JsonWriter writer = new JsonWriter("./data/testWriterFilledDataSpace.json");
            writer.open();
            writer.write(dataSpace);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterFilledDataSpace.json");
            dataSpace = reader.read();
            assertEquals("Data space 4", dataSpace.getName());
            List<DataVector> dateVectors = dataSpace.getDataVectors();
            assertEquals(3, dateVectors.size());
            checkDataVector("population", testDds1, dateVectors.get(0));
            checkDataVector("fires", testDds2, dateVectors.get(1));
            checkDataVector("floods", testDds3, dateVectors.get(2));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    private void fillDataSets() {
        testDds1 = new DoubleDataSet(true);
        testDds2 = new DoubleDataSet(false);
        testDds3 = new DoubleDataSet(true);
        for (int i = 0; i < 7; i++) {
            if (i < 2) {
                testDds2.addData(new DoubleData(i * 2.0));
            }
            if (i < 5) {
                testDds1.addData((new DoubleData(i * 1.0)));
            }
            testDds3.addData(new DoubleData(i * 3.0));
        }
    }
}
