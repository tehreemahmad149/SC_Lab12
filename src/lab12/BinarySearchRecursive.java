package lab12;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchRecursive {

    /**
     * Performs a recursive binary search on a sorted array of integers.
     *
     * @param array The sorted array to search in.
     * @param target The target value to search for.
     * @param left The starting index of the current search range.
     * @param right The ending index of the current search range.
     * @return The index of the target value if found, or -1 if not found.
     */
	//integer implementation
    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (array == null || array.length == 0) {
            return -1; //  null or empty array
        }
        if (left > right) {
            return -1; //  target does not exist
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            return mid; // found
        } else if (array[mid] > target) {
            return binarySearchRecursive(array, target, left, mid - 1); // look in the left half
        } else {
            return binarySearchRecursive(array, target, mid + 1, right); // look in the right half
        }
    }

    /**
     * Performs a recursive binary search on a sorted array of strings.
     *
     * @param array The sorted array of strings to search in.
     * @param target The target value to search for.
     * @param left The starting index of the current search range.
     * @param right The ending index of the current search range.
     * @return The index of the target value if found, or -1 if not found.
     */
  //integer implementation
    public static int binarySearchRecursive(String[] array, String target, int left, int right) {
        if (array == null || array.length == 0 || target == null) {
            return -1;
        }
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (array[mid].compareTo(target) == 0) {
            return mid;
        } else if (array[mid].compareTo(target) > 0) {
            return binarySearchRecursive(array, target, left, mid - 1);
        } else {
            return binarySearchRecursive(array, target, mid + 1, right);
        }
    }

    /**
     * Finds all indices of the target value in a sorted array.
     *
     * @param array The sorted array to search in.
     * @param target The target value to search for.
     * @param left The starting index of the current search range.
     * @param right The ending index of the current search range.
     * @return A list of all indices where the target value is found.
     */
  //looking for all indexes
    public static List<Integer> binarySearchAllIndices(int[] array, int target, int left, int right) {
        List<Integer> indices = new ArrayList<>();

        int index = binarySearchRecursive(array, target, left, right);
        if (index == -1) {
            return indices; 
        }

        //recursively look for in left side and right side
        int temp = index;
        while (temp >= 0 && array[temp] == target) {
            indices.add(temp--);
        }
        
        temp = index + 1;
        while (temp < array.length && array[temp] == target) {
            indices.add(temp++);
        }

        Collections.sort(indices); // sort the indexes
        return indices;
    }

}
