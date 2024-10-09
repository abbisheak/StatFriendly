package model;

// Represents Rational data in a data set
public class DoubleData implements Data<Double> {

    //Effects: data's value is given value
    public DoubleData(Double data){
        // stub
    }

    //Effects: returns true if given data matches this data
    //         up to 10 decimal places, false otherwise
    public Boolean compare(Double data) {
        // stub
        return false;
    }

    //Effects: returns true if given data contains the same data
    //         as this up to a 10 decimal point accuracy, 
    //         false otherwise
    public Boolean compare(Data<Double> data) {
        // stub
        return false;
    }

    public void setData(Double newData) {
        // stub
    }

    public Double getData() {
        // stub
        return null;
    }
    
}
