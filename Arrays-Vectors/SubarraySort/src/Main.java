public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer[] numbers = {1,2,3,6,5,8,4,7,9,10,11};

        int smallestNumber = Integer.MAX_VALUE;
        int largestNumber = Integer.MIN_VALUE;

        for (int i=1; i< numbers.length; i++) {
            if (numbers[i] < numbers[i-1]) {
                smallestNumber = Math.min(smallestNumber, numbers[i]);
                largestNumber = Math.max(largestNumber, numbers[i-1]);
            }
        }

        if (smallestNumber == Integer.MAX_VALUE) {
            System.out.println("[-1,-1]");
            return;
        }

        int startIndex = 0;
        int endIndex = numbers.length-1;

        for (int j = 0; smallestNumber >= numbers[j]; j++) {
            startIndex = j+1;
        }

        for (int j = numbers.length-1; largestNumber <= numbers[j]; j--) {
            endIndex = j-1;
        }

        System.out.println("["+startIndex+","+endIndex+"]");
    }
}
