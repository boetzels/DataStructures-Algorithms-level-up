import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer[] numbers = {10, 11, 5, 2, 4, 3, 2, 1};
        /*numbers = new Integer[]{2, 4, 5, 1, 3};
        numbers = new Integer[]{5, 4, 3, 2, 2, 1};*/

        // first sort the array
        Integer[] numbersSorted = numbers.clone();
        Arrays.sort(numbersSorted);

        // save position of every number in a hash
        HashMap<Integer, LinkedList<Integer>> positionOfNumbers = new HashMap<>();
        for (int i = 0; i < numbersSorted.length; i++) {
            if (!positionOfNumbers.containsKey(numbersSorted[i])) {
                positionOfNumbers.put(numbersSorted[i], new LinkedList<>());
            }
            positionOfNumbers.get(numbersSorted[i]).add(i);
        }

        // calc amount of swaps
        int swaps = 0;
        HashSet<Integer> indexesSwapped = new HashSet<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (!indexesSwapped.contains(i)) {
                Integer actualNumber = numbers[i];
                Integer nextNumberIndex = positionOfNumbers.get(actualNumber).removeFirst();
                while (nextNumberIndex != i) {
                    actualNumber = numbers[nextNumberIndex];
                    indexesSwapped.add(nextNumberIndex);
                    nextNumberIndex = positionOfNumbers.get(actualNumber).removeFirst();
                    swaps++;
                 }
            }
        }

        System.out.println("Minimum number of swaps: "+swaps);
    }
}
