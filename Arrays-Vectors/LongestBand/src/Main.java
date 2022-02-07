import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] numbers = {1,9,3,0,18,5,2,4,10,7,12,6};

        HashSet<Integer> numbersPresent = new HashSet<Integer>();

        for (int i=0; i< numbers.length; i++) {
            numbersPresent.add(numbers[i]);
        }

        int[] longestBand = new int[]{0,0};
        for (int i=0; i< numbers.length; i++) {
            // check if we found head
            if (!numbersPresent.contains(numbers[i]-1)) {
                int newBandStart = numbers[i];
                int newBandEnd = numbers[i];
                for (int bandNumber = newBandStart; numbersPresent.contains(bandNumber); bandNumber++) {
                    newBandEnd = bandNumber;
                }
                if (getBandSize(newBandStart,newBandEnd) >= getBandSize(longestBand[0], longestBand[1])) {
                    longestBand = new int[]{newBandStart, newBandEnd};
                }
            }
        }

        System.out.println(Arrays.toString(longestBand));
    }

    public static int getBandSize(int bandStart, int bandEnd) {
        return bandEnd - bandStart + 1;
    }
}
