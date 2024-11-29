package model.dataset;

import java.util.HashSet;
import java.util.Iterator;

import model.logging.Event;
import model.logging.EventLog;

// Represents a data set for a specific concept
public abstract class DataSet<T, W> {

    protected HashSet<W> dataSet;
    protected Boolean isSample;
    protected Double mean;
    protected T median;
    protected T mode;
    protected T max;
    protected T min;
    protected Double standardDeviation;

    // REQUIRES: The generic used for W must be T - W<T>
    // EFFECTS: creates an empty data set with no elements in it;
    // if isSample makes DataSet a sample DataSet,
    // otherwise a population DataSet
    public DataSet(Boolean isSample) {
        dataSet = new HashSet<>();
        this.isSample = isSample;
    }

    // MODIFIES: this
    // EFFECTS: If data != null AND !contains(data) add data to set and
    // recalculate statistical information, otherwise do nothing
    public void addData(W data) {
        if (data != null && !contains(data)) {
            dataSet.add(data);
            calculate(data);
            EventLog.getInstance().logEvent(new Event("Data entry added to data set for data vector."));
        }
    }

    // MODIFIES: this
    // EFFECTS: If set contains given data, then remove data from data set
    // otherwise do nothing
    public void removeData(W data) {
        if (contains(data)) {
            dataSet.remove(data);
        }
    }

    // EFFECTS: returns true if given data is in set, otherwise false
    public Boolean contains(W data) {
        return dataSet.contains(data);
    }

    // MODIFIES: this
    // EFFECTS: removes all data entries from data set, and sets all
    // statistical calculations to null
    public void clear() {
        dataSet.clear();
        mean = null;
        median = null;
        mode = null;
        max = null;
        min = null;
        standardDeviation = null;
    }

    // EFFECTS: returns an iterator for the data set
    public Iterator<W> iterator() {
        return dataSet.iterator();
    }

    // EFFECTS: returns the number of data entries in the data set
    public int size() {
        return dataSet.size();
    }

    // REQUIRES: !dataSet.isEmpty()
    // EFFECTS: returns true if DataSet contains data for a sample population,
    // else return false meaning DataSet contains data for a population
    public Boolean isSample() {
        return isSample;
    }

    // REQUIRES: !dataSet.isEmpty()
    public Double getMean() {
        EventLog.getInstance().logEvent(new Event("Data vector mean retreived"));
        return mean;
    }

    // REQUIRES: !dataSet.isEmpty()
    public T getMedian() {
        EventLog.getInstance().logEvent(new Event("Data vector median retreived"));
        return median;
    }

    // REQUIRES: !dataSet.isEmpty()
    public T getMode() {
        EventLog.getInstance().logEvent(new Event("Data vector mode retreived"));
        return mode;
    }

    // REQUIRES: !dataSet.isEmpty()
    public T getMax() {
        EventLog.getInstance().logEvent(new Event("Data vector max retreived"));
        return max;
    }

    // REQUIRES: !dataSet.isEmpty()
    public T getMin() {
        EventLog.getInstance().logEvent(new Event("Data vector min retreived"));
        return min;
    }

    // REQUIRES: !dataSet.isEmpty()
    public Double getStandardDeviation() {
        EventLog.getInstance().logEvent(new Event("Data vector standard deviation retreived"));
        return standardDeviation;
    }

    public HashSet<W> getData() {
        return dataSet;
    }

    // REQUIRES: !dataSet.isEmpty() AND data != null
    // MODIFIES: this
    // EFFECTS: calculates the new mean, median, mode, max, min and
    // standard deviation accordingly to present dataSet state
    private void calculate(W data) {
        setMean();
        setMedian();
        setMode();
        setMax(data);
        setMin(data);
        setStandardDeviation();
        EventLog.getInstance().logEvent(new Event("Calculated statistics for data set."));
    }

    // MODIFIES: this
    // EFFECTS: recalculates and sets the value of mean based on dataSet
    // state
    protected abstract void setMean();

    // MODIFIES: this
    // EFFECTS: If size() is even, set median to the size()/2 greatest
    // element of the set, else set median to the (size()/2 + 1) greatest
    // element of the set
    protected abstract void setMedian();

    // MODIFIES: this
    // EFFECTS: sets mode to the data value with greatest amount of occurences
    // with a bias towards to the lesser data value, that is, if data values
    // have equivalent occurences, the lesser data value is chosen
    protected abstract void setMode();

    // MODIFIES: this
    // EFFECTS: if data.getData() > max OR max == null, set max to data.getData(),
    // otherwise do nothing
    protected abstract void setMax(W data);

    // MODIFIES: this
    // EFFECTS: if data.getData() < min OR min == null, set min to data.getData(),
    // otherwise do nothing
    protected abstract void setMin(W data);

    // MODIFIES: this
    // EFFECTS: if isSample() and size > 1 calculate sample standard deviation,
    // else calculate population standard deviation
    protected abstract void setStandardDeviation();
}
