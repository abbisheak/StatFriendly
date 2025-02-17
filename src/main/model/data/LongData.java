package model.data;

// Represents Integer data in a data set
public class LongData implements Data<Long> {
    private Long data;

    // EFFECTS: data's value is given value
    public LongData(Long data) {
        this.data = data;
    }

    // EFFECTS: returns true if given data matches this data
    // false otherwise
    public Boolean compare(Long data) {
        return this.data.equals(data);
    }

    // EFFECTS: returns true if given data contains the same data
    // as this, false otherwise
    public Boolean compare(Data<Long> data) {
        return compare(data.getData());
    }

    public void setData(Long newData) {
        data = newData;
    }

    public Long getData() {
        return data;
    }

}
