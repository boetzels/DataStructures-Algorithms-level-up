import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String s = "()(()){}{[()]}(((())))()((()()()()()))(((())))()(()";


        System.out.print(checkBalancedBrackets(s));

    }

    private static boolean checkBalancedBrackets(String string) {
        Deque<String> stack = new LinkedList<>();

        for (int i = 0; i < string.length(); i++) {
            String bracket = String.valueOf(string.charAt(i));
            if (bracket.equals("(") || bracket.equals("{") || bracket.equals("[") ) {
                stack.push(bracket);
            }
            else if ( stack.size() > 0 &&
                    (
                        bracket.equals(")") && stack.peek().equals("(") ||
                        bracket.equals("}") && stack.peek().equals("{") ||
                        bracket.equals("]") && stack.peek().equals("[")
                    )
                )
            {
                stack.pop();
            }
            else {
                return false;
            }
        }

        return stack.size() == 0;
    }
}
