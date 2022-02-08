public class Main {

    public static void main(String[] args) {
	// write your code here
        StringBuilder text = new StringBuilder("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Consequat id porta nibh venenatis cras sed felis eget velit. Tristique et egestas quis ipsum suspendisse. Pellentesque diam ");

        System.out.println(text);

        String replaceChar = " ";
        int amountOfReplaceChars = 0;
        int fromIndex = 0;
        int indexOf = text.indexOf(replaceChar);
        while (indexOf != -1) {
            fromIndex = indexOf+1;
            indexOf = text.indexOf(replaceChar, fromIndex);
            amountOfReplaceChars++;
        }

        System.out.println("We have "+amountOfReplaceChars+" spaces");

        int newIndex = text.length()+2*amountOfReplaceChars-1;
        int textLength = text.length();
        text.setLength(text.length()+2*amountOfReplaceChars);

        for (int i = textLength-1; i >= 0; i--) {
            char actualChar = text.charAt(i);
            if (String.valueOf(actualChar).equals(replaceChar)) {
                text.setCharAt(newIndex--, '0');
                text.setCharAt(newIndex--, '2');
                text.setCharAt(newIndex--, '%');
            }
            else {
                text.setCharAt(newIndex--, actualChar);
            }
        }

        System.out.println(text);
    }
}
