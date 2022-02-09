import java.util.*;

public class Main {

    private static ArrayList<String> subsequencesMain = new ArrayList<>();

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Give string: ");
        String text = sc.next();

        long trainingTimeStartRec = System.currentTimeMillis();
        getAllSubsequencesRec(text,"");
        sortSubsequences(subsequencesMain);
        long trainingTimeEndRec = System.currentTimeMillis();
        System.out.println("Rec "+(trainingTimeEndRec-trainingTimeStartRec)+" ms benötigt");

        long trainingTimeStart = System.currentTimeMillis();
        ArrayList<String> sortedSubsequences = sortSubsequences(getAllSubsequences(text));
        long trainingTimeEnd = System.currentTimeMillis();
        System.out.println("Loop "+(trainingTimeEnd-trainingTimeStart)+" ms benötigt");

        //System.out.println(Arrays.asList(sortedSubsequences.toArray()));
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

        return subsequences;
    }

    private static void getAllSubsequencesRec(String text, String subsequence) {
        if (text.isEmpty()) {
            subsequencesMain.add(subsequence);
            return;
        }

        String actualString = String.valueOf(text.charAt(0));
        String newText = text.substring(1);

        getAllSubsequencesRec(newText, subsequence.concat(actualString));
        getAllSubsequencesRec(newText, subsequence);
    }

    private static ArrayList<String> sortSubsequences(ArrayList<String> subsequences) {
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
