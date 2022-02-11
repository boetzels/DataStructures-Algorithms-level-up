import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Give a String to encode: ");
        String text = sc.next();

        System.out.println(RunLengthEncoding(text));
    }

    private static String RunLengthEncoding(String text) {
        StringBuilder result = new StringBuilder();

        char lastChar = text.charAt(0);
        int amountOfLastChar = 1;
        for (int i = 1; i < text.length(); i++) {
            char actualChar = text.charAt(i);
            if (actualChar != lastChar) {
                result.append(concatCharEncoding(lastChar,amountOfLastChar));
                lastChar = actualChar;
                amountOfLastChar = 1;
            }
            else {
                amountOfLastChar++;
            }
        }
        result.append(concatCharEncoding(lastChar,amountOfLastChar));

        String resultString = result.toString();
        return resultString.length() < text.length() ? resultString : text;
    }

    private static String concatCharEncoding(char addChar, int addAmount) {
        return String.valueOf(addChar).concat(Integer.toString(addAmount));
    }
}
