package model.dataspace;

import org.json.JSONArray;
import org.json.JSONObject;

import model.dataset.DoubleDataSet;

import java.util.List;
import java.util.ArrayList;

import persistence.Writable;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a data space having a data set
public class DataSpace implements Writable {
    private String name;
    private List<DataVector> dataVectors;

    // EFFECTS: constructs a data space with an associating name and containing no
    // data vectors
    public DataSpace(String name) {
        this.name = name;
        dataVectors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: adds data vector to data space
    public void addDataVector(DataVector dataVector) {
        dataVectors.add(dataVector);
    }

    // EFFECTS: returns a modifiable list data vectors in this data space
    public List<DataVector> getDataVectors() {
        return dataVectors;
    }

    // EFFECTS: returns number of data vectors in this data space
    public int numDataVectors() {
        return dataVectors.size();
    }

    // EFFECTS: returns dataVector in the data space with corresponding 
    // name, but if none found return null
    public DataVector getDataVector(String name) {
        DataVector dataVector = null;
        for (DataVector dv : dataVectors) {
            if (dv.getName().equals(name)) {
                dataVector = dv;
            }
        }

        return dataVector;
    }

    // EFFECTS: returns a json object for this data space
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("data vectors", dataVectorsToJson());
        return json;
    }

    // EFFECTS: returns data vectors in this data space as a JSON array
    private JSONArray dataVectorsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (DataVector dataVector : dataVectors) {
            jsonArray.put(dataVector.toJson());
        }
        return jsonArray;
    }

}
