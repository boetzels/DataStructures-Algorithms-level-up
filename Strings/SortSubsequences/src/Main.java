import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Give string: ");
        String text = sc.next();

        ArrayList<String> sortedSubsequences = getAllSubsequences(text);
        System.out.println(Arrays.asList(sortedSubsequences.toArray()));
        System.out.println(sortedSubsequences.size());
    }

    private static ArrayList<String> getAllSubsequences(String text) {
        ArrayList<String> subsequences = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            String actualString = String.valueOf(text.charAt(i));
            subsequences.add(actualString);
            int actualSize = subsequences.size();
            for (int i2 = 0; i2 < actualSize-1; i2++) {
                String addSubsequence = subsequences.get(i2);
                if (actualString.compareTo(addSubsequence) > 0) {
                    subsequences.add(addSubsequence.concat(actualString));
                }
                else {
                    subsequences.add(actualString.concat(addSubsequence));
                }
            }
        }

        Collections.sort(subsequences, (String s1, String s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            } else if (s1.length() < s2.length()) {
                return -1;
            }
            return 1;
        });

        return subsequences;
    }
}
