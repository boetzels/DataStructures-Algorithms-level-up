import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String text = "abcdef";

        System.out.println(GetPermutations(text));
    }

    public static String GetPermutations(String text) {
        String result = "";

        if (text.length() <= 1) {
            return text;
        }
        else {
            for (int i = 0; i < text.length(); i++) {
                String letter = String.valueOf(text.charAt(i));
                String subText = text.substring(0, i).concat(text.substring(i + 1));

                String subResult = GetPermutations(subText);

                int j = 0;
                while (j < subResult.length()) {
                    int nextIndex = subResult.indexOf(",",j);
                    if (nextIndex <= 0) {
                        result = result.concat(letter.concat(subResult.concat(",")));
                        break;
                    }
                    String nextSubResult = subResult.substring(j, nextIndex);
                    if (nextSubResult.length() > 0) {
                        result = result.concat(letter.concat(nextSubResult.concat(",")));
                    }
                    j += nextIndex + 1;
                }
            }
        }

        return result;
    }
}
