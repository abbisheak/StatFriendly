package model.dataspace;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import model.data.DoubleData;
import model.dataset.DoubleDataSet;
import persistence.Writable;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a data space having a data set
public class DataSpace implements Writable{

    // EFFECTS: constructs a data space with an associating name and a empty data set
    public DataSpace(String name){
    //stub
    }

    public String getName(){
        //stub
        return null;
    }

    // MODIFIES: this
    // EFFECTS: adds data to data space
    public void addData(DoubleData data){
        //stub
    }

    // EFFECTS: returns the data set of this data space
    public DoubleDataSet getDataSet() {
        //stub
        return null;
    }

    // EFFECTS: returns number of data entries in this data space
    public int numData() {
        //stub
        return -1;
    }

    @Override
    public JSONObject toJson() {
        //stub
        return null;
    }

    // EFFECTS: returns data entries in this data space as a JSON array
    private JSONArray dataToJson() {
        //stub
        return null;
    }
    
}
