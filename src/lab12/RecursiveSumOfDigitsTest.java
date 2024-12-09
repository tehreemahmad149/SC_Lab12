package lab12;

import static org.junit.Assert.*;

import org.junit.Test;


public class RecursiveSumOfDigitsTest {

    @Test
    public void testSumOfDigitsPositive() {
        assertEquals(6, RecursiveSumOfDigits.sumOfDigits(123)); // 1 + 2 + 3 = 6
    }

    @Test
    public void testSumOfDigitsNegative() {
        assertEquals(15, RecursiveSumOfDigits.sumOfDigits(-456)); // 4 + 5 + 6 = 15
    }

    @Test
    public void testSumOfDigitsZero() {
        assertEquals(0, RecursiveSumOfDigits.sumOfDigits(0));
    }

    @Test
    public void testSumOfDigitsLargeNumber() {
        assertEquals(4, RecursiveSumOfDigits.sumOfDigits(3100)); // 3 + 1 + 0 + 0 = 4
    }

    @Test
    public void testSumOfDigitsEdgeCase() {
        assertEquals(46, RecursiveSumOfDigits.sumOfDigits(Integer.MAX_VALUE)); // 2 + 1 + 4 + 7 + 4 + 8 + 3 + 6 + 4 + 7 = 46
    }
}
