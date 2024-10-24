package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

import model.DataSpace;

// Represents a reader that reads a data space from JSON data stored in file
public class JsonReader {
    
    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        //stub
    }

    // EFFECTS: reads data space from file and returns it;
    // throws IOException if an error occurs reading data from file
    public DataSpace read() throws IOException {
        //stub
        return null;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        return null;
    }
    
}
