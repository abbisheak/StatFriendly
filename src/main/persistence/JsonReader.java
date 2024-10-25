package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

import model.data.DoubleData;
import model.dataset.DoubleDataSet;
import model.dataspace.DataSpace;
import model.dataspace.DataVector;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a reader that reads a data space from JSON data stored in file
public class JsonReader {
    private String source;
    
    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads data space from file and returns it;
    // throws IOException if an error occurs reading data from file
    public DataSpace read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseDataSpace(jsonObject);
    }

 
    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses DataSpace from JSON object and returns it
    private DataSpace parseDataSpace(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        DataSpace dataSpace = new DataSpace(name);
        addDataVectors(dataSpace, jsonObject);
        return dataSpace;
    }

    // MODIFIES: dataSpace
    // EFFECTS: parses thingies from JSON object and adds them to DataSpace
    private void addDataVectors(DataSpace dataSpace, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("data vectors");
        for (Object json : jsonArray) {
            JSONObject nextDataVector = (JSONObject) json;
            addDataVector(dataSpace, nextDataVector);
        }
    }

    // MODIFIES: dataSpace
    // EFFECTS: parses DataVector from JSON object and adds it to DataSpace
    private void addDataVector(DataSpace dataSpace, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        DoubleDataSet doubleDataSet = convertJsonArrayToDataSet(jsonObject.getJSONArray("data set"));
        DataVector dataVector = new DataVector(name, doubleDataSet);
        dataSpace.addDataVector(dataVector);
    }

    // EFFECTS: parses data set from JSON Array and returns data set
    private DoubleDataSet convertJsonArrayToDataSet(JSONArray jsonArray){
        DoubleDataSet doubleDataSet = new DoubleDataSet(false);
        for(int i = 0; i < jsonArray.length(); i++){
            doubleDataSet.addData(new DoubleData(jsonArray.getDouble(i)));
        }
        return doubleDataSet;
    }
}

