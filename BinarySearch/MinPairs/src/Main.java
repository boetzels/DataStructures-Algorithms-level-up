import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] numbers1 = {-1, 5, 10, 20, 3};
        int[] numbers2 = {26, 134, 135, 15, 17};

        System.out.println(Arrays.toString(MinPairs(numbers1, numbers2)));
    }

    public static int[] MinPairs(int[] numbers1, int[] numbers2) {
        int[] result = new int[2];
        int minDif = Integer.MAX_VALUE;

        Arrays.sort(numbers2);
        System.out.println(Arrays.toString(numbers2));

        for (int i = 0; i < numbers1.length; i++) {
            int lowerBound = getLowerBound(numbers2, numbers1[i]);
            if (Math.abs(numbers1[i] - numbers2[lowerBound]) < minDif) {
                minDif = Math.abs(numbers1[i] - numbers2[lowerBound]);
                result[0] = numbers1[i];
                result[1] = numbers2[lowerBound];
            }
            else if (lowerBound > 0 && Math.abs(numbers1[i] - numbers2[lowerBound - 1]) < minDif) {
                minDif = Math.abs(numbers1[i] - numbers2[lowerBound - 1]);
                result[0] = numbers1[i];
                result[1] = numbers2[lowerBound - 1];
            }
        }

        return result;
    }

    public static int getLowerBound(int[] numbers, int k) {
        int sIndex = 0;
        int eIndex = numbers.length - 1;
        int lowerBound = 0;

        while (sIndex <= eIndex) {
            int middleIndex = sIndex + (eIndex - sIndex) / 2;

            if (numbers[middleIndex] == k || numbers[middleIndex] > k) {
                eIndex = middleIndex - 1;
            }
            else {
                sIndex = middleIndex + 1;
            }
            lowerBound = middleIndex;
        }

        if (lowerBound < numbers.length - 1 && numbers[lowerBound] < k) {
            lowerBound++;
        }

        return lowerBound;
    }
}
