import java.util.*;

public class Main {
    private static String inputText = "";
    private static int inputCol = 0;
    private static boolean reverseOrder = false;
    private static String comparisonType = "n";

    public static void main(String[] args) {
	// write your code here
        askInput();
        String[][] sortedString = StringKeySort(inputText, inputCol, comparisonType, reverseOrder);

        for (String[] lineOfString : sortedString) {
            System.out.println(Arrays.asList(lineOfString));
        }
    }

    public static void askInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please give column index (starting with 0): ");
        int col = sc.nextInt();

        String text = "";
        System.out.println("Please give string (end with empty line): ");
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            text = text.concat(line.concat("\n"));
            if (line.isEmpty()) {
                break;
            }
        }

        System.out.print("Comparison type (l: lexicographic / n: numeric): ");
        String type = sc.nextLine();

        System.out.print("Reverse order? (y / n): ");
        String reverse = sc.nextLine();

        inputCol = col;
        inputText = text;
        comparisonType = type;

        reverseOrder = reverse.equals("y");
    }

    public static String[][] StringKeySort(String text, int col, String comparisonT, boolean reverse) {
        String[][] workingTokens = tokenizeText(text);

        if (comparisonType.equals("n")) {
            Arrays.sort(workingTokens, Comparator.comparingInt(o -> Integer.parseInt(o[col])));
        }
        else {
            Arrays.sort(workingTokens, Comparator.comparing(o -> o[col]));
        }

        if (reverse) {
            Collections.reverse(Arrays.asList(workingTokens));
        }

        return workingTokens;
    }

    public static String[][] tokenizeText(String text) {
        String[] lines = text.split("\n");
        String[][] result = new String[lines.length][lines[0].split("\s").length];

        for (int i = 0; i < lines.length; i++) {
            result[i] = lines[i].split("\s");
        }

        return result;
    }
}
