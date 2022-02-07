import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] numbers = {
            5, 6, 1, 2, 3, 4, 5, 4, 3, 2, 0, 1, 2, 3, -2, 4
        };

        System.out.println("The numbers: "+Arrays.toString(numbers));
        System.out.println("The highest peak: "+Arrays.toString(findHighestPeak(numbers)));

    }

    public static int[] findHighestPeak(int[] numbers) {
        int lastValleyIndex = 0;
        int lastPeakIndex = 0;
        int[] highestPeak = {0,0};

        // first and last element can't be peaks
        for (int i=1; i<numbers.length-1; i++) {
            // check for valley
            if (numbers[i-1] > numbers[i] && numbers[i+1] > numbers[i]) {
                highestPeak = calculatePeakSize(highestPeak, lastValleyIndex, i, lastPeakIndex);
                lastValleyIndex = i;
            }
            // else check for peak
            else if (numbers[i-1] < numbers[i] && numbers[i+1] < numbers[i]) {
                lastPeakIndex = i;
                if (i == numbers.length-2) {
                    highestPeak = calculatePeakSize(highestPeak, lastValleyIndex, i+1, lastPeakIndex);
                }
            }
        }
        return highestPeak;
    }

    public static int[] calculatePeakSize(int[] highestPeak, int lastValleyIndex, int actualValleyIndex, int lastPeakIndex) {
        int peakSize = actualValleyIndex-lastValleyIndex+1;
        if (lastPeakIndex != 0 && highestPeak[0] < peakSize) {
            return new int[]{peakSize, lastPeakIndex};
        }
        return new int[]{highestPeak[0], highestPeak[1]};
    }
}
