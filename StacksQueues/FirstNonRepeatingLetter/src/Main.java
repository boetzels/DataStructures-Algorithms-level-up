import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String text = "aabccbcaöosjölaksjdoflkashklajhslkdjfhsdfpoiwqpuerd";

        System.out.println(GetFirstNonRepeatingLetters(text));
    }

    public static String GetFirstNonRepeatingLetters(String text) {
        LinkedList<String> result = new LinkedList<>();

        Queue<String> stack = new LinkedList<>();
        HashMap<String, Integer> letters = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            String actualLetter = String.valueOf(text.charAt(i));

            if (letters.containsKey(actualLetter)) {
                letters.computeIfPresent(actualLetter, (k, v) -> v + 1);
            }
            else {
                letters.put(actualLetter, 1);
                stack.offer(actualLetter);
            }

            int j = 0;
            while (j++ < text.length()) {
                String readStack = stack.peek();

                if (readStack == null) {
                    result.offer("-1");
                    break;
                }
                else if (letters.get(readStack) > 1) {
                    stack.poll();
                }
                else {
                    result.offer(readStack);
                    break;
                }
            }
        }

        return result.toString();
    }
}
