package model.data;

// Represents Rational data in a data set
public class DoubleData implements Data<Double> {
    private static final Double MAX_ACCURACY = 0.00001;

    private Double data;

    // EFFECTS: data's value is given value
    public DoubleData(Double data) {
        this.data = data;
    }

    // EFFECTS: returns true if given data matches this data
    // up to 5 decimal places, false otherwise
    public Boolean compare(Double data) {
        System.out.println(this.data - data);
        return Math.abs((this.data - data)) < MAX_ACCURACY;
    }

    // EFFECTS: returns true if given data contains the same data
    // as this up to a 5 decimal point accuracy,
    // false otherwise
    public Boolean compare(Data<Double> data) {
        return compare(data.getData());
    }

    public void setData(Double newData) {
        this.data = newData;
    }

    public Double getData() {
        return data;
    }

}
