public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer[] numbers = {-1, 2, 3, 4, -2, 6, -8, 3};

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i=0; i< numbers.length; i++) {
            currentSum = currentSum + numbers[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            else if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        System.out.println("The maximum Subarray-Sum is: "+maxSum);
    }
}
