import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer[] numbers = {0,1,0,2,1,0,1,3,2,1,2,1};

        ArrayList<Integer> highestFromLeft = new ArrayList<Integer>();
        ArrayList<Integer> highestFromRight = new ArrayList<Integer>();

        highestFromLeft.add(numbers[0]);
        highestFromRight.add(numbers[numbers.length-1]);
        for (int i=1; i<numbers.length; i++) {
            highestFromLeft.add(Math.max(numbers[i], highestFromLeft.get(i-1)));
            highestFromRight.add(Math.max(numbers[numbers.length-1-i], highestFromRight.get(i-1)));
        }

        int rain = 0;
        for (int i=0; i<numbers.length; i++) {
            rain += Math.min(highestFromLeft.get(i),highestFromRight.get(numbers.length-1-i))-numbers[i];
        }

        System.out.println("Total rain: "+rain);
    }
}
