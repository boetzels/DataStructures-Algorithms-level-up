import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Integer[] numbers = {26, 134, 9, 136, 14, 5, 19};
        Integer[] numbers = {1, 2, 3, 4, 5};

        System.out.println(Arrays.asList(getArrayOfProducts(numbers).toArray()));
    }

    public static ArrayList<Integer> getArrayOfProducts(Integer[] numbers) {
        ArrayList<Integer> result = new ArrayList<>();

        result.add(1);
        for (int i = 1; i < numbers.length; i++) {
            result.add(numbers[i-1]*result.get(i-1));
        }

        int rightProduct = 1;
        for (int i = numbers.length-2; i >= 0; i--) {
            rightProduct *= numbers[i+1];
            result.set(i, rightProduct * result.get(i));
        }

        return result;
    }
}
