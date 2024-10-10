package model.data;

// Represents data in a data set
public interface Data<T> {

    // Effects: returns true if given data matches this data
    // false otherwise
    public abstract Boolean compare(T data);

    // Effects: returns true if given data contains the same data
    // as this, false otherwise
    public abstract Boolean compare(Data<T> data);

    public void setData(T newData);

    public T getData();

}
