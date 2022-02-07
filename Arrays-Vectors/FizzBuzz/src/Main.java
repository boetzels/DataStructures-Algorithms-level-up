import java.util.Vector;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print("Give a number: ");
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        System.out.println("You entered: "+n);
        Vector<String> fizzBuzz = FizzBuzz(n);

        System.out.println(fizzBuzz);
    }

    public static Vector<String> FizzBuzz(int n) {
        Vector<String> result = new Vector<String>();

        for (int index=1; index<=n; index++) {
            if (index % 3 == 0) {
                result.add("Fizz");
            }
            else if (index % 5 == 0) {
                result.add("Buzz");
            }
            else {
                result.add(String.valueOf(index));
            }
        }

        return result;
    }
}
