import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String s = "()(()){}{[()]}(((())))()((()()()()()))(((())))()(()";


        System.out.print(checkBalancedBrackets(s));

    }

    private static boolean checkBalancedBrackets(String string) {
        ArrayList<String> stack = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            String bracket = String.valueOf(string.charAt(i));
            if (bracket.equals("(") || bracket.equals("{") || bracket.equals("[") ) {
                stack.add(bracket);
            }
            else if ( stack.size() > 0 &&
                    (
                        bracket.equals(")") && stack.get(stack.size()-1).equals("(") ||
                        bracket.equals("}") && stack.get(stack.size()-1).equals("{") ||
                        bracket.equals("]") && stack.get(stack.size()-1).equals("[")
                    )
                )
            {
                stack.remove(stack.size()-1);
            }
            else {
                return false;
            }
        }

        return true;
    }
}
