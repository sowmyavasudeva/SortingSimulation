package sorting.types;

/**
 * Implementation of Merge Sort.
 */
public class MergeSort implements Sort {
    public int[] sort(int[] arrayToSort, int low, int high){
        //base case
        if(low == high){
            int[] oneElement = new int[]{arrayToSort[low]};
            return oneElement;
        }

        //recursive case
        int middle = low + (high - low) / 2;
        int[] firstSortedArray = sort(arrayToSort, low, middle);
        int[] secondSortedArray = sort(arrayToSort, middle + 1 , high) ;
        return Merge(firstSortedArray, secondSortedArray);

    }

    //code to merge the 2 halves of the array
    public static int[] Merge(int[] Array1, int[] Array2){

        int[] sortedArray = new int[Array1.length + Array2.length];
        int k = 0;
        int i = 0, j = 0;
        while (i < Array1.length && j < Array2.length){
            if(Array1[i] < Array2[j]){
                sortedArray[k++] = Array1[i++];
            }else{
                sortedArray[k++] = Array2[j++];
            }
        }

        while(i < Array1.length){
            sortedArray[k++] = Array1[i++];
        }
        while(j < Array2.length){
            sortedArray[k++] = Array2[j++];
        }
        return sortedArray;
    }

    @Override
    public int[] sort(int[] inputArray) {
        
        // null and empty validation
        if (inputArray == null || inputArray.length == 0 || inputArray.length == 1) {
            return inputArray;
        }
        return sort(inputArray, 0, inputArray.length - 1);
    }
}
