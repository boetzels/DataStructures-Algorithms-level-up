import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Integer[] numbers = {10, 1, 1, 234, 34, 2, 5, 2, 0, 7, 6, 4};

        Integer[] result = MergeSortInversionCount(numbers);

        System.out.println(result[result.length - 1]);
    }

    private static Integer[] MergeSortInversionCount(Integer[] sortArray) {
        if (sortArray.length <= 1) {
            return new Integer[]{sortArray[0], 0};
        }

        int divider = sortArray.length / 2;

        Integer[] leftPart = MergeSortInversionCount(Arrays.copyOfRange(sortArray, 0, divider));
        Integer[] rightPart = MergeSortInversionCount(Arrays.copyOfRange(sortArray, divider, sortArray.length));

        return Merge(leftPart, rightPart);
    }

    private static  Integer[] Merge(Integer[] leftPart, Integer[] rightPart) {
        int i = 0;
        int j = 0;
        int k = 0;

        int inversionCount = leftPart[leftPart.length - 1] + rightPart[rightPart.length - 1];

        Integer[] result = new Integer[leftPart.length + rightPart.length - 1];

        while (i + j < leftPart.length + rightPart.length - 2) {
            if (j == rightPart.length - 1 || i < leftPart.length - 1 && leftPart[i] <= rightPart[j]) {
                result[k++] = leftPart[i++];
            }
            else {
                inversionCount += leftPart.length - i - 1;
                result[k++] = rightPart[j++];
            }
        }

        result[leftPart.length + rightPart.length - 2] = inversionCount;

        return result;
    }
}
