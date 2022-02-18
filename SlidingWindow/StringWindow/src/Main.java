import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String text1 = "fizzbuzz";
        String text2 = "fuzz";

        String result = getStringWindow(text1,text2);

        System.out.println(result);
    }

    private static String getStringWindow(String bigString, String smallString) {
        Integer[] resultIndexes = new Integer[]{};
        HashMap<String, Integer> letters = new HashMap<>();
        HashMap<String, Integer> lettersInWindow = new HashMap<>();

        for (int k = 0; k < smallString.length(); k++) {
            String letter = String.valueOf(smallString.charAt(k));
            if (!letters.containsKey(letter)) {
                letters.put(letter,1);
                lettersInWindow.put(letter,1);
            }
            else {
                letters.replace(letter, letters.get(letter) + 1);
                lettersInWindow.replace(letter, lettersInWindow.get(letter) + 1);
            }
        }

        int i = 0;
        int j = 0;
        int windowLettersCount = smallString.length();
        int minSize = bigString.length();

        while (i < bigString.length()) {
            String actualIChar = String.valueOf(bigString.charAt(i));

            if (letters.containsKey(actualIChar)) {
                Integer actualLetterInWindow = lettersInWindow.get(actualIChar);
                if (actualLetterInWindow > 0) {
                    windowLettersCount--;
                }
                lettersInWindow.replace(actualIChar, actualLetterInWindow - 1);
            }

            if (windowLettersCount == 0) {
                while (windowLettersCount <= 0 && j <= i) {
                    String actualJChar = String.valueOf(bigString.charAt(j++));
                    if (lettersInWindow.containsKey(actualJChar)) {
                        Integer actualJCount = lettersInWindow.get(actualJChar);
                        lettersInWindow.replace(actualJChar, actualJCount + 1);
                        if (actualJCount >= 0) {
                            windowLettersCount++;
                        }
                    }
                }

                if (minSize > i - j + 2) {
                    resultIndexes = new Integer[]{j - 1,i};
                    minSize = i - j + 2;
                }
            }

            i++;
        }

        StringBuilder result = new StringBuilder();
        result.ensureCapacity(minSize);

        if (resultIndexes.length > 0) {
            for (int k = resultIndexes[0]; k <= resultIndexes[1]; k++) {
                result.append(bigString.charAt(k));
            }
        }

        return result.toString();
    }
}
