package model;

import java.util.HashSet;
import java.util.Iterator;

// Represents a data set for a specific concept
public abstract class DataSet<T, W> {

    // Requires: The generic used for W must be T - W<T>
    // Effects: creates an empty data set with no elements in it; 
    // if isSample makes DataSet a sample DataSet, 
    // otherwise a population DataSet
    public DataSet(Boolean isSample) {
    }

    // Modifies: this
    // Effects: If data != null AND !contains(data) add data to set and
    // recalculate statistical information, otherwise do nothing
    public void addData(W data) {
    }

    // Modifies: this
    // Effects: If set contains given data, then remove data from data set
    // otherwise do nothing
    public void removeData(W data){
    }

    // Effects: returns true if given data is in set, otherwise false
    public Boolean contains(W data) {
        return null;
    }

    // Modifies: this
    // Effects: removes all data entries from data set, and sets all 
    // statistical calculations to null
    public void clear() {
    }

    // Effects: returns an iterator for the data set
    public Iterator<W> iterator() {
        return null;
    }

    // Effects: returns the number of data entries in the data set
    public int size() {
        return 0;
    }

    // Requires: !dataSet.isEmpty()
    // Effects: returns true if DataSet contains data for a sample population,
    // else return false meaning DataSet contains data for a population
    public Boolean isSample() {
        return null;
    }

    // Requires: !dataSet.isEmpty()
    public Double getMean() {
        return null;
    }

    // Requires: !dataSet.isEmpty()
    public T getMedian() {
        return null;
    }

    // Requires: !dataSet.isEmpty()
    public T getMode() {
        return null;
    }

    // Requires: !dataSet.isEmpty()
    public T getMax() {
        return null;
    }

    // Requires: !dataSet.isEmpty()
    public T getMin() {
        return null;
    }

    // Requires: !dataSet.isEmpty()
    public Double getStandardDeviation() {
        return null;
    }

    public HashSet<W> getData() {
        return null;
    }

    // Requires: !dataSet.isEmpty() AND data != null
    // Modifies: this
    // Effects: calculates the new mean, median, mode, max, min and
    // standard deviation accordingly to present dataSet state
    private void calculate(W data) {
    }

    // Modifies: this
    // Effects: recalculates and sets the value of mean based on dataSet
    // state
    protected abstract void setMean();

    // Modifies: this
    // Effects: If size() is even, set median to the size()/2 greatest 
    // element of the set, else set median to the (size()-1)/2 greatest 
    // element of the set
    protected abstract void setMedian();

    // Modifies: this
    // Effects: sets mode to the data value with greatest amount of occurences
    // with a bias towards to the lesser data value, that is, if data values 
    // have equivalent occurences, the lesser data value is chosen
    protected abstract void setMode();

    // Modifies: this
    // Effects: if data.getData() > max, set max to data.getData(), otherwise 
    // do nothing
    protected abstract void setMax(W data);

    // Modifies: this
    // Effects: if data.getData() < min, set min to data.getData(), otherwise 
    // do nothing
    protected abstract void setMin(W data);

    // Modifies: this
    // Effects: if isSample() calculate sample standard deviation, else calculate
    // population standard deviation 
    protected abstract void setStandardDeviation();
}
