package model.dataTests;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public interface DataTest {

    @BeforeEach
    void runBefore();

    @Test
    public void testConstructor();

    @Test
    public void testCompareDataValue();

    @Test
    public void testCompareDataObject();

    @Test
    public void testSetData();

    @Test
    public void testGetData();
    
}
