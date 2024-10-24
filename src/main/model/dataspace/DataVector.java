package model.dataspace;

import org.json.JSONObject;

import model.dataset.DoubleDataSet;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class DataVector {
    
    public DataVector(String id, DoubleDataSet dataSet){
        // stub
    }

    public String getName() {
        // stub
        return null;
    }

    public DoubleDataSet getDataSet() {
        // stub
        return null;
    }

    // EFFECTS: returns string representation of this data vector
    public String toString() {
        return null;
    }

    // EFFECTS: returns this data vector as a JSON object
    public JSONObject toJson() {
        // stub
        return null;
    }
}
