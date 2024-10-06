package model;

// Data entry for a data set
public class DataEntry<T> {

    /*
     * REQUIRES: originalData is one of: Double, Integer, or String
     * EFFECTS: data entry is recorded as originalData
     *          if data instanceOf Double set data as originalData with
     *          the decimal removed, else record data as originalData
     */
    public DataEntry(T data) { 
    }

    // EFFECTS: returns data 
    public T getData(){
        return null;
    }

    // EFFECTS: returns originalData
    public T getOriginalData(){
        return null;
    }
}
