package lab12;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class BinarySearchRecursiveTest {
	//format
	//binarySearchRecursive(int[] array, int target, int left, int right)

    @Test
    public void testBinarySearchIntTargetFound() {
        int[] array = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(3, BinarySearchRecursive.binarySearchRecursive(array, 7, 0, array.length - 1));
    }

    @Test
    public void testBinarySearchIntTargetNotFound() {
        int[] array = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(-1, BinarySearchRecursive.binarySearchRecursive(array, 6, 0, array.length - 1));
    }

    @Test
    public void testBinarySearchEmptyArray() {
        int[] array = {};
        assertEquals(-1, BinarySearchRecursive.binarySearchRecursive(array, 7, 0, array.length - 1));
    }

    @Test
    public void testBinarySearchNullArray() {
        assertEquals(-1, BinarySearchRecursive.binarySearchRecursive(null, 7, 0, 0));
    }
    //variant tests
    @Test
    public void testBinarySearchStringTargetFound() {
        String[] array = {"apple", "banana", "cherry", "date", "fig", "grape"};
        assertEquals(2, BinarySearchRecursive.binarySearchRecursive(array, "cherry", 0, array.length - 1));
    }

    @Test
    public void testBinarySearchStringTargetNotFound() {
        String[] array = {"apple", "banana", "cherry", "date", "fig", "grape"};
        assertEquals(-1, BinarySearchRecursive.binarySearchRecursive(array, "kiwi", 0, array.length - 1));
    }
    //indexes with duplicate targets so array return

    @Test
    public void testBinarySearchAllIndices() {
        int[] array = {1, 3, 5, 5, 5, 9, 11};
        List<Integer> expectedIndices = List.of(2, 3, 4);
        assertEquals(expectedIndices, BinarySearchRecursive.binarySearchAllIndices(array, 5, 0, array.length - 1));
    }
}
