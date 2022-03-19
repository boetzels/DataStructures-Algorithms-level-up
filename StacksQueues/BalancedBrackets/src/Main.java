import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String s = "()(()){}{[()]}(((())))()((()()()()()))(((())))()(()";


        System.out.print(checkBalancedBrackets(s));

    }

    private static boolean checkBalancedBrackets(String string) {
        LinkedList<String> stack = new LinkedList<>();

        for (int i = 0; i < string.length(); i++) {
            String bracket = String.valueOf(string.charAt(i));
            if (bracket.equals("(") || bracket.equals("{") || bracket.equals("[") ) {
                stack.offerLast(bracket);
            }
            else if ( stack.size() > 0 &&
                    (
                        bracket.equals(")") && stack.peekLast().equals("(") ||
                        bracket.equals("}") && stack.peekLast().equals("{") ||
                        bracket.equals("]") && stack.peekLast().equals("[")
                    )
                )
            {
                stack.removeLast();
            }
            else {
                return false;
            }
        }

        return stack.size() == 0;
    }
}
