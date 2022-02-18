import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer[] numbers = {10, 1, 1, 234, 34, 2, 5, 2, 0, 7, 6, 4};

        System.out.println(Arrays.asList(MergeSort(numbers)));
    }

    private static Integer[] MergeSort(Integer[] sortArray) {
        if (sortArray.length <= 1) {
            return sortArray;
        }

        int divider = sortArray.length / 2;

        Integer[] leftPart = MergeSort(Arrays.copyOfRange(sortArray, 0, divider));
        Integer[] rightPart = MergeSort(Arrays.copyOfRange(sortArray, divider, sortArray.length));

        int i = 0;
        int j = 0;
        int k = 0;
        Integer[] result = new Integer[sortArray.length];

        while (i + j < leftPart.length + rightPart.length) {
            if (j == rightPart.length || i < leftPart.length && leftPart[i] <= rightPart[j]) {
                result[k++] = leftPart[i++];
            }
            else {
                result[k++] = rightPart[j++];
            }
        }

        return result;
    }
}
