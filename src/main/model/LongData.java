package model;

// Represents Integer data in a data set
public class LongData implements Data<Long>{

    //Effects: data's value is given value
    public LongData(Long data){
        // stub
    }

    //Effects: returns true if given data matches this data
    //         false otherwise
    public Boolean compare(Long data) {
        // stub
        return false;
    }

    //Effects: returns true if given data contains the same data
    //         as this, false otherwise
    public Boolean compare(Data<Long> data) {
        // stub
        return false;
    }

    public void setData(Long newData) {
        // stub
    }

    public Long getData() {
        // stub
        return null;
    }
    
}
