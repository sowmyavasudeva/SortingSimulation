package sorting.types;

import java.util.List;

/**
 * Implementation of Insertion Sort.
 */
public class InsertionSort implements Sort {
    @Override
    public int[] sort(int inputArray[]) {
        // null and empty validation
        if (inputArray == null || inputArray.length == 0 || inputArray.length == 1) {
            return inputArray;
        }

        // Move numbers that are
        // greater than key by one position
        for (int i = 1; i < inputArray.length; ++i) {
            int key = inputArray[i];
            int j = i - 1;
            while (j >= 0 && inputArray[j] > key) {
                inputArray[j + 1] = inputArray[j];
                j = j - 1;
            }
            inputArray[j + 1] = key;
        }

        return inputArray;
    }
}