package model.dataspace;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashSet;

import model.data.DoubleData;
import model.dataset.DoubleDataSet;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class DataVector {
    private String name;
    private DoubleDataSet dataSet;

    // EFFECTS: constructs a data vector with given name and value of given data set
    public DataVector(String name, DoubleDataSet dataSet) {
        this.name = name;
        this.dataSet = dataSet;
    }

    public String getName() {
        return name;
    }

    public DoubleDataSet getDataSet() {
        return dataSet;
    }

    // EFFECTS: returns this data vector as a JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("data set", dataSetToJson());
        return json;
    }

    // EFFECTS: returns this data set as a JSON Array
    private JSONArray dataSetToJson() {
        JSONArray jsonArray = new JSONArray();
        HashSet<DoubleData> dataList = dataSet.getData();

        for (DoubleData data : dataList) {
            jsonArray.put(data.getData());
        }
        return jsonArray;
    }
}
