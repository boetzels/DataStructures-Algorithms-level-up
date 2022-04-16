import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] numbers = {0, -2, 1, 2, 3, 4, 5, 15, 10, 5};
        int k = 15;

        System.out.println(LongestSubArrayKSum(numbers, k));
    }

    public static int LongestSubArrayKSum(int[] numbers, int k) {
        int longest = 0;
        int sum = 0;
        HashMap<Integer, Integer> PrevSums = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];

            if (sum == k && longest < i + 1) {
               longest = i + 1;
            }

            if (PrevSums.containsKey(sum - k) && longest < i - PrevSums.get(sum - k) + 1) {
                longest = i - PrevSums.get(sum - k) + 1;
            }
            else {
                PrevSums.putIfAbsent(sum, i);
            }
        }

        return longest;
    }
}
