import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer[] numbers1 = {25, 5, 10, 17, 30};
        Integer[] numbers2 = {26, 134, 9, 136, 14, 19};

        System.out.println(Arrays.asList(getMinimumDifference(numbers1, numbers2)));
    }

    public static Integer[] getMinimumDifference(Integer[] numbers1, Integer[] numbers2) {
        Arrays.sort(numbers1);
        Arrays.sort(numbers2);

        System.out.println(Arrays.asList(numbers1));
        System.out.println(Arrays.asList(numbers2));

        Integer[] result = new Integer[]{numbers1[0], numbers2[0], Integer.MAX_VALUE};

        int i2 = 0;
        for (int i = 0; i < numbers1.length; i++) {
            while (numbers1[i] > numbers2[i2] && i2 < numbers2.length) {
                result = checkBestDifference(numbers1[i], numbers2[i2], result);
                i2++;
            }
            result = checkBestDifference(numbers1[i], numbers2[i2], result);
        }

        return new Integer[]{result[0], result[1]};
    }

    public static Integer[] checkBestDifference(int number1, int number2, Integer[] bestDifference) {
        int actualDifference = Math.abs(number1 - number2);
        if (actualDifference < bestDifference[2]) {
            return new Integer[]{number1, number2, actualDifference};
        }
        return bestDifference;
    }
}
