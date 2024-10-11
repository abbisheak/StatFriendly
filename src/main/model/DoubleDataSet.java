package model;

import model.data.DoubleData;

public class DoubleDataSet extends DataSet<Double, DoubleData> {

    // Effects: creates an empty data set with no elements in it; 
    // if isSample makes DataSet a sample DataSet, 
    // otherwise a population DataSet
    public DoubleDataSet(Boolean isSample) {
        super(isSample);
    }

    // Modifies: this
    // Effects: recalculates and sets the value of mean based on dataSet
    // state
    protected void setMean() {
        // stub
    }

    // Modifies: this
    // Effects: If size() is even, set median to the size()/2 greatest 
    // element of the set, else set median to the (size()-1)/2 greatest 
    // element of the set
    protected void setMedian() {
        // stub
    }

    // Modifies: this
    // Effects: sets mode to the data value with greatest amount of occurences
    // with a bias towards to the lesser data value, that is, if data values 
    // have equivalent occurences, the lesser data value is chosen
    protected void setMode() {
        // stub
    }

    // Modifies: this
    // Effects: if data.getData() > max, set max to data.getData(), otherwise 
    // do nothing
    protected void setMax(DoubleData data) {
        // stub
    }

    // Modifies: this
    // Effects: if data.getData() < min, set min to data.getData(), otherwise 
    // do nothing
    protected void setMin(DoubleData data) {
        // stub
    }

    // Modifies: this
    // Effects: if isSample() calculate sample standard deviation, else calculate
    // population standard deviation 
    protected void setStandardDeviation() {
        // stub
    }
    
}
