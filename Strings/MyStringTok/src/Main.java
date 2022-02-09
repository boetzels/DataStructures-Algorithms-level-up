import java.util.Scanner;

public class Main {

    private static String strTokInput = "";

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        String text;
        System.out.print("Please give string: ");
        text = sc.nextLine();

        String token = MyStrTok(text," ");
        while (!token.equals("")) {
            System.out.println(token);
            token = MyStrTok(""," ");
        }
    }

    public static String MyStrTok(String text, String delimiter) {
        if (text.isEmpty()) {
            text = strTokInput;
        }

        StringBuilder workingText = new StringBuilder(text);
        StringBuilder token = new StringBuilder();

        int foundDelimiterAt = workingText.length();
        for (int i = 0; i < workingText.length(); i++) {
            char actualChar = workingText.charAt(i);
            if (actualChar == delimiter.charAt(0)) {
                foundDelimiterAt = i+1;
                break;
            }
            token.append(actualChar);
        }
        workingText.delete(0,foundDelimiterAt);

        strTokInput = workingText.toString();
        return token.toString();
    }
}
