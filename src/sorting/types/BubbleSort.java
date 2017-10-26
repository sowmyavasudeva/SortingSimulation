package sorting.types;

/**
 * Implementation of Bubble Sort
 */
public class BubbleSort implements Sort {

    @Override
    public int[] sort(int inputArray[]) {
        // null and empty validation
        if (inputArray == null || inputArray.length == 0 || inputArray.length == 1) {
            return inputArray;
        }

        int temp;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 1; j < (inputArray.length - i); j++) {
                // if the current number is less than the previous one, then
                // swap the values
                if (inputArray[j - 1] > inputArray[j]) {
                    temp = inputArray[j - 1];
                    inputArray[j - 1] = inputArray[j];
                    inputArray[j] = temp;
                }
            }
        }

        return inputArray;
    }
}