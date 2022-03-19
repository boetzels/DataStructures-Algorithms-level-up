import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] numbers = {1, 2, 3, 1, 2, 1, 1, 1, 4, 5, 2, 3, 5};

        int k = 3;

        System.out.println(Arrays.toString(GetMaxSubArray(numbers, k)));
    }

    public static int[] GetMaxSubArray(int[] numbers, int k) {
        int[] result = new int[numbers.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            Integer head = deque.peekFirst();
            while (head != null && numbers[head] <= numbers[i]) {
                deque.pollFirst();
                head = deque.peekFirst();
            }
            deque.offerFirst(i);
        }

        for (int i = k; i < numbers.length; i++) {
            Integer tail = deque.peekLast();
            result[i - k] = numbers[tail];
            if (tail != null && tail <= i - k) {
                deque.pollLast();
            }

            Integer head = deque.peekFirst();
            while (head != null && numbers[head] <= numbers[i]) {
                deque.pollFirst();
                head = deque.peekFirst();
            }
            deque.offerFirst(i);
        }

        result[result.length - 1] = numbers[deque.peekLast()];

        return result;
    }
}
