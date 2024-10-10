package model;

import java.util.HashSet;
import java.util.Iterator;

// Represents a data set for a single concept
public class DataSet<T, W> {

    // Requires: The generic used for W must be T: W<T>
    // Effects: creates an empty data set with no elements in in it and all
    // statistic calculations set to 0;
    public DataSet(Boolean isSample) {
        // stub
    }

    // Modifies: this
    // Effects: If data != null AND !contains(data) add to set and recalculate
    // statistical information, otherwise do nothing;
    public void addData(W data) {
        // stub
    }

    // Modifies: this
    // Effects: If set contains given data, then remove data from data set
    // otherwise do nothing
    public void removeData(W data) {
        // stub
    }

    // Effects: returns true if given data is in set, otherwise false
    public Boolean contains(W data) {
        // stub
        return false;
    }

    // Modifies: this
    // Effects: removes all data entries in a data set
    public void clear() {
        // stub
    }

    // Effects: returns an iterator for the data set
    public Iterator<W> iterator() {
        // stub
        return null;
    }

    // Effects: returns the number of data entries in DataSet
    public int size() {
        // stub
        return 0;
    }

    // Effects: returns true if DataSet is data for a sample population
    public Boolean isSample() {
        // stub
        return false;
    }

    public Double getMean() {
        // stub
        return null;
    }

    // Effects: If size() is even, return the size()/2 greatest element
    // of the set, else return the (size()-1)/2 greatest element of the 
    // set
    public T getMedian() {
        // stub
        return null;
    }

    // Effects: Returns the data value with greatest amount of occurences
    // with a bias towards to the lesser data value
    public T getMode() {
        // stub
        return null;
    }

    public T getMax() {
        // stub
        return null;
    }

    public T getMin() {
        // stub
        return null;
    }

    // Effects: If isSample, returns zero (base value) until size() > 1,
    // then returns calculated standard deviation, else return standard
    // deviation
    public Double getStandardDeviation() {
        // stub
        return null;
    }

    public HashSet<W> getData() {
        // stub
        return null;
    }
}
