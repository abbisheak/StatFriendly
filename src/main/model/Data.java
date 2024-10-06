package model;

// Data for a data set
public class Data<T> {

    /*
     * REQUIRES: originalData is one of: Double, Integer, or String
     * EFFECTS: records originalData;
     *          if data instanceOf Double set data as originalData with
     *          the decimal removed, else record data as originalData
     */
    public Data(T data) { 
    }

    /*
    *  MODIFIES: this
    *  EFFECTS: updates originalData with newData;
    *           if newData instanceOf Double set newData as originalData
    *           with the decimal removed, else record newData as
    *            originalData
    */
    public void updateDate(T newData){
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
