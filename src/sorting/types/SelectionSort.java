package sorting.types;

/**
 * Implementation of Selection Sort.
 */
public class SelectionSort implements Sort {
    @Override
    public int[] sort(int inputArray[]) {
        // null and empty validation
        if (inputArray == null || inputArray.length == 0 || inputArray.length == 1) {
            return inputArray;
        }

        for (int i = 0; i < inputArray.length - 1; i++) {

            // Find minimum number in the array which is still not sorted
            int minIndex = i;
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[j] < inputArray[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the number at minIndex with number a first index, then
            // second and so on.
            int temp = inputArray[minIndex];
            inputArray[minIndex] = inputArray[i];
            inputArray[i] = temp;
        }

        return inputArray;
    }
}