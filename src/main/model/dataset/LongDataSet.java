package model.dataset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import model.data.LongData;

// Represents a data set for a specific concept quantified with
// integers 
public class LongDataSet extends DataSet<Long, LongData> {

    // EFFECTS: creates an empty data set with no elements in it;
    // if isSample makes DataSet a sample DataSet,
    // otherwise a population DataSet
    public LongDataSet(Boolean isSample) {
        super(isSample);
    }

    // MODIFIES: this
    // EFFECTS: recalculates and sets the value of mean based on dataSet
    // state
    protected void setMean() {
        Double sum = 0.0;

        for (LongData data : dataSet) {
            sum += data.getData();
        }

        mean = sum / dataSet.size();
    }

    // MODIFIES: this
    // EFFECTS: If size() is even, set median to the size()/2 greatest
    // element of the set, else set median to the (size()/2 + 1) greatest
    // element of the set
    protected void setMedian() {
        ArrayList<Long> sortedList = sortedData(iterator());
        int stop;

        if (dataSet.size() % 2 == 0) {
            stop = (dataSet.size() / 2) - 1;
        } else {
            stop = ((dataSet.size() + 1) / 2) - 1;
        }

        median = sortedList.get(stop);

    }

    // MODIFIES: this
    // EFFECTS: sets mode to the data value with greatest amount of occurences
    // with a bias towards to the lesser data value, that is, if data values
    // have equivalent occurences, the lesser data value is chosen
    protected void setMode() {
        ArrayList<Long> sortedList = sortedData(iterator());
        int occurences = 0;

        for (LongData data : dataSet) {
            int dataOccurences = Collections.frequency(sortedList, data.getData());
            if (dataOccurences > occurences) {
                occurences = dataOccurences;
                mode = data.getData();
            } else if (dataOccurences == occurences && data.getData() < mode) {
                mode = data.getData();
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: if data.getData() > max OR max == null, set max to data.getData(),
    // otherwise do nothing
    protected void setMax(LongData data) {
        if (max == null || data.getData() > max) {
            max = data.getData();
        }
    }

    // MODIFIES: this
    // EFFECTS: if data.getData() < min OR min == null, set min to data.getData(),
    // otherwise do nothing
    protected void setMin(LongData data) {
        if (min == null || data.getData() < min) {
            min = data.getData();
        }
    }

    // MODIFIES: this
    // EFFECTS: if isSample() and size > 1 calculate sample standard deviation,
    // else calculate population standard deviation
    protected void setStandardDeviation() {
        Double differenceSummation = 0.0;
        if (isSample && dataSet.size() > 1) {
            for (LongData data : dataSet) {
                differenceSummation += Math.pow((data.getData() - mean), 2.0);
            }
            standardDeviation = Math.sqrt(differenceSummation / (dataSet.size() - 1));
        } else {
            for (LongData data : dataSet) {
                differenceSummation += Math.pow((data.getData() - mean), 2.0);
            }
            standardDeviation = Math.sqrt(differenceSummation / dataSet.size());
        }
    }

    // EFFECTS: sorts data to be in increasing order in a list and returns that
    // list
    private ArrayList<Long> sortedData(Iterator<LongData> data) {
        ArrayList<Long> dataList = new ArrayList<>();

        while (data.hasNext()) {
            dataList.add(data.next().getData());
        }

        Collections.sort(dataList);

        return dataList;
    }

}
