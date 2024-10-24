package persistence;

import org.json.JSONObject;

import model.dataspace.DataSpace;

import java.io.*;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a writer that writes JSON representation of DataSpace to file
public class JsonWriter {

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination){
        //stub
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException{
        //stub
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of data space to file
    public void write(DataSpace dataSpace) {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        //stub
    }
}
