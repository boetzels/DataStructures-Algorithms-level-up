import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] stockPrices = {100,80,60,70,60,75,85};

        System.out.println(Arrays.toString(GetStockSpans(stockPrices)));
    }

    public static int[] GetStockSpans(int[] stockPrices) {
        int[] result = new int[stockPrices.length];
        Stack<Integer> stack = new Stack<>();

        // the first is always 1
        result[0] = 1;
        stack.push(0);

        for (int i = 1; i < stockPrices.length; i++) {
            // remove all that are smaller than actual stock price from stack
            while (!stack.empty() && stockPrices[stack.peek()] < stockPrices[i]) {
                stack.pop();
            }

            result[i] = (!stack.empty()) ? i - stack.peek() : i;

            stack.push(i);
        }

        return result;
    }
}
