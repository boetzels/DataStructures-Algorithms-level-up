import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String numbers = "10,11,2,110,34,102,20,30,3";
        //String numbers = "10,111";

        String[] numbersArray = numbers.split(",");

        Arrays.sort(numbersArray, (String s1, String s2) -> s2.concat(s1).compareTo(s1.concat(s2)));

        System.out.println(String.join("", numbersArray));
    }
}
