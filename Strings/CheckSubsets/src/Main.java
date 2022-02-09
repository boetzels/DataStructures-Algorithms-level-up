public class Main {

    public static void main(String[] args) {
	// write your code here
        String text = "coding minutes";
        String subset = "cines";

        System.out.println(checkSubset(text,subset));
    }

    private static boolean checkSubset(String text, String subset) {
        int i2 = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == subset.charAt(i2)) {
                if (++i2 == subset.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}
