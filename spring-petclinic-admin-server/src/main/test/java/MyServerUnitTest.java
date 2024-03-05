import  org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyServerUnitTest{

    @Test
    public void simpleTest(){
        int expected = 1;
        int actual = 1;

        assertEquals(expected, actual, 'The actual value should be equal to the expected one!')
    }
}