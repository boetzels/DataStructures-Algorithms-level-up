import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String text = "abbaababba";

        System.out.println(AnagramsInSubstrings(text));
    }

    public static int AnagramsInSubstrings(String text) {
        HashMap<String, Integer> frequency = new HashMap<>();

        for (int windowSize = 1; windowSize < text.length(); windowSize++) {
            int i = 0;
            int j = windowSize;

            while (j <= text.length()) {
                String subString = text.substring(i, j);
                String hash = HashString(subString);

                if (frequency.containsKey(hash)) {
                    int oldFreq = frequency.get(hash);
                    frequency.replace(hash, oldFreq + 1);
                }
                else {
                    frequency.put(hash, 1);
                }
                i++;
                j++;
            }
        }

        int count = 0;
        for (int value : frequency.values()) {
            count += value * (value - 1) / 2;
        }

        return count;
    }

    public static String HashString(String string) {
        int[] hash = new int[26];

        for (int i = 0; i < string.length(); i++) {
            int ascii = string.charAt(i) - 'a';
            hash[ascii] += 1;
        }

        StringBuilder result = new StringBuilder();
        result.ensureCapacity(result.length());
        for (int f : hash) {
            result.append(String.valueOf(f).charAt(0));
        }
        return result.toString();
    }
}
