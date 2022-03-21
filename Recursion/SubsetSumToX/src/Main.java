public class Main {

    public static void main(String[] args) {
	// write your code here
        int sum = 20;
        int[] numbers = {10, 12, 15, 6, 19, 20};

        System.out.println(SubsetSumToX(0, 0, sum, numbers));
    }

    public static boolean SubsetSumToX(int sum, int nextIndex, int targetSum, int[] numbers) {
        boolean result = false;
        int nextSum = sum + numbers[nextIndex];

        if (nextSum == targetSum) {
            result = true;
        }
        else if (nextIndex < numbers.length - 1) {
            if (nextSum < targetSum) {
                result = SubsetSumToX(nextSum, nextIndex + 1, targetSum, numbers);
            }
            if (!result) {
                result = SubsetSumToX(sum, nextIndex + 1, targetSum, numbers);
            }
        }

        return result;
    }
}
