package sorting.types;

/**
 * Implementation of Quick Sort Sort.
 */
public class QuickSort implements Sort {

    // Find pivot i.e an index where all numbers to the left are lesser than
    // pivot and all numbers to the right are greater
    public int partition(int arrayToSort[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arrayToSort[(left + right) / 2];

        while (i <= j) {
            while (arrayToSort[i] < pivot)
                i++;
            while (arrayToSort[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arrayToSort[i];
                arrayToSort[i] = arrayToSort[j];
                arrayToSort[j] = tmp;
                i++;
                j--;
            }
        }

        return i;
    }

    // Find pivot and recursvely call quicksort on two halves
    public void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    @Override
    public int[] sort(int[] inputArray) {
        // null and empty validation
        if (inputArray == null || inputArray.length == 0 || inputArray.length == 1) {
            return inputArray;
        }

        // Initialize QuickSort
        quickSort(inputArray, 0, inputArray.length - 1);

        return inputArray;
    }
}