import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer[] numbers = {10,4,3,8,11,45,23,1,22,43,-2,-67,-44,-23,-5,-7,15};
        System.out.println("The numbers are: "+Arrays.asList(numbers));
        System.out.print("Give a sum: ");

        Scanner scanner = new Scanner(System.in);

        int sum = scanner.nextInt();

        ArrayList<ArrayList<Integer>> resultList = tripletSum(sum, numbers);

        System.out.println("The result is:");
        System.out.println(resultList);
    }

    public static ArrayList<ArrayList<Integer>> tripletSum(int sum, Integer[] numbers) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();

        Arrays.sort(numbers);

        for (int i=0; i < numbers.length-2; i++) {
            int sumLeft = sum-numbers[i];
            int startPointer = i+1;
            int endPointer = numbers.length-1;

            while (endPointer > startPointer) {
                int actualSum = numbers[startPointer] + numbers[endPointer];

                if (actualSum == sumLeft) {
                    resultList.add(new ArrayList<Integer>(Arrays.asList(numbers[i],numbers[startPointer],numbers[endPointer])));
                    endPointer--;
                    startPointer++;
                }
                else if (actualSum > sumLeft) {
                    endPointer--;
                }
                else {
                    startPointer++;
                }
            }
        }

        return resultList;
    }

    public static ArrayList<Integer> pairSumTwoPointer(int sum, Integer[] numbers) {
        int startPointer = 0;
        int endPointer = numbers.length-1;

        while (endPointer > startPointer) {
            int actualSum = numbers[startPointer] + numbers[endPointer];

            if (actualSum == sum) {
                return new ArrayList<Integer>(Arrays.asList(numbers[startPointer],numbers[endPointer]));
            }
            else if (actualSum > sum) {
                endPointer--;
            }
            else {
                startPointer++;
            }
        }
        return new ArrayList<Integer>();
    }

    public static Integer[] pairSum(int sum, Integer[] numbers) {
        Set<Integer> numbersChecked = new HashSet<>();

        for (int i=0; i < numbers.length; i++) {
            int lookForNumber = sum-numbers[i];

            if (numbersChecked.contains(lookForNumber)) {
                return new Integer[]{numbers[i], lookForNumber};
            }
            numbersChecked.add(numbers[i]);
        }
        return new Integer[]{};
    }
}
