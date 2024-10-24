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
    // EFFECTS: adds data vector to data space
    public void addDataVector(DataVector data){
        //stub
    }

    // EFFECTS: returns a modifiable list data vectors in this data space
    public List<DataVector> getDataVectors() {
        //stub
        return null;
    }

    // EFFECTS: returns number of data vectors in this data space
    public int numDataVectors() {
        //stub
        return -1;
    }

    @Override
    public JSONObject toJson() {
        //stub
        return null;
    }

    // EFFECTS: returns data vectors in this data space as a JSON array
    private JSONArray dataVectorsToJson() {
        //stub
        return null;
    }
    
}
