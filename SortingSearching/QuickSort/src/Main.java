import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer[] numbers = {10, 1, 1, 234, 34, 2, 5, 2, 0, 7, 6, 4};

        System.out.println(Arrays.asList(QuickSort(numbers, 0, numbers.length - 1)));
    }

    private static Integer[] QuickSort(Integer[] sortArray, int startIndex, int pivotIndex) {
        if (startIndex < pivotIndex) {
            int nextIndex = Partition(sortArray, startIndex, pivotIndex);
            QuickSort(sortArray, nextIndex + 1, pivotIndex);
            QuickSort(sortArray, 0, nextIndex - 1);
        }

        return sortArray;
    }

    private static int Partition(Integer[] sortArray, int startIndex, int pivotIndex) {
        // take the last element as pivot point
        int pivot = sortArray[pivotIndex];

        int i = startIndex - 1;
        for (int j = startIndex; j < pivotIndex; j++) {
            // if smaller, swap element with last border element
            if (sortArray[j] <= pivot) {
                int swap = sortArray[j];
                sortArray[j] = sortArray[++i];
                sortArray[i] = swap;
            }
        }

        // put pivot at correct position
        sortArray[pivotIndex] = sortArray[++i];
        sortArray[i] = pivot;

        return i;
    }
}
