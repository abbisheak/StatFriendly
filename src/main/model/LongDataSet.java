package model;

import model.data.LongData;

public class LongDataSet extends DataSet<Long, LongData>{

    // Effects: creates an empty data set with no elements in it;
    // if isSample makes DataSet a sample DataSet,
    // otherwise a population DataSet
    public LongDataSet(Boolean isSample) {
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
    // element of the set, else set median to the (size()/2 + 1) greatest
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
    // Effects: if data.getData() > max OR max == null, set max to data.getData(),
    // otherwise do nothing
    protected void setMax(LongData data) {
        // stub
    }

    // Modifies: this
    // Effects: if data.getData() < min OR min == null, set min to data.getData(),
    // otherwise do nothing
    protected void setMin(LongData data) {
        // stub
    }

    // Modifies: this
    // Effects: if isSample() and size > 1 calculate sample standard deviation,
    // else calculate population standard deviation
    protected void setStandardDeviation() {
        // stub
    }
    
}
