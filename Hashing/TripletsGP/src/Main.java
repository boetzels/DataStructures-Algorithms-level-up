import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] numbers = {1, 16, 4, 16, 64, 16};
        int ratio = 4;

        System.out.println(TripletsInGP(numbers, ratio));
    }

    public static int TripletsInGP(int[] numbers, int r) {
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();

        // fill right & init left
        for (int i : numbers) {
            if (right.containsKey(i)) {
                right.put(i, right.get(i) + 1);
            }
            else {
                left.put(i, 0);
                right.put(i, 1);
            }
        }

        // get triplets by looking left and right
        int triplets = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            Integer nbrLeft = left.getOrDefault(numbers[i] / r, 0);
            Integer nbrRight = right.getOrDefault(numbers[i] * r, 0);

            if (numbers[i] % r == 0) {
                triplets += nbrLeft * nbrRight;
            }

            left.put(numbers[i], left.get(numbers[i]) + 1);
            right.put(numbers[i], right.get(numbers[i]) - 1);
        }

        return triplets;
    }
}
