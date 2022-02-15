import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String text = "alkjhjhsjsdef";

        String result = getLargestUniqueSubstring(text);

        System.out.println(result);
    }

    private static String getLargestUniqueSubstring(String text) {
        Integer[] resultIndexes = new Integer[]{};
        HashSet<String> letters = new HashSet<>();

        int i = 0;
        int j = 0;
        int maxSize = 0;

        while (i < text.length()) {
            char actualIChar = text.charAt(i);

            boolean charAlreadyInString = letters.contains(String.valueOf(actualIChar));
            while (charAlreadyInString && j <= i) {
                char actualJChar = text.charAt(j++);
                letters.remove(String.valueOf(actualJChar));
                charAlreadyInString = letters.contains(String.valueOf(actualIChar));
            }

            letters.add(String.valueOf(actualIChar));

            if (maxSize < i - j + 1) {
                resultIndexes = new Integer[]{j,i};
                maxSize = i - j + 1;
            }
            i++;
        }

        StringBuilder result = new StringBuilder();
        result.ensureCapacity(maxSize);

        for (int k = resultIndexes[0]; k <= resultIndexes[1]; k++) {
            result.append(text.charAt(k));
        }

        return result.toString();
    }
}
