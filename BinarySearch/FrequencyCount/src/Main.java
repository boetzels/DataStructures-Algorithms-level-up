import java.util.Scanner;

public class Main {
    public static int c = 0;
    public static int c2 = 0;
    public static void main(String[] args) {
	// write your code here
        int[] numbers = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 4, 4, 5, 10, 10, 10, 10, 10};

        Scanner sc = new Scanner(System.in);

        System.out.print("Give element to count: ");

        int k = sc.nextInt();

        System.out.println(getFrequencyCount(numbers, k)+" :: "+c);
        System.out.println(getFrequencyCount2(numbers, k)+" :: "+c2);


    }

    public static int getFrequencyCount(int[] numbers, int k) {
        int firstIndex = binarySearch(numbers, k, 0, numbers.length - 1);

        if (firstIndex < 0) {
            return -1;
        }

        int lowIndex = firstIndex;
        int highIndex = firstIndex;
        while (lowIndex > 0 && numbers[lowIndex - 1] == k) {
            lowIndex = binarySearch(numbers, k, 0, lowIndex - 1);
        }

        while (highIndex < numbers.length - 1 && numbers[highIndex + 1] == k) {
            highIndex = binarySearch(numbers, k, highIndex + 1, numbers.length - 1);
        }

        return highIndex - lowIndex + 1;
    }

    public static int getFrequencyCount2(int[] numbers, int k) {
        int lowIndex = 0;
        int highIndex = numbers.length - 1;

        int lowAns = -1;

        while(lowIndex<=highIndex)
        {
            c2++;
            int mid = (lowIndex+highIndex)/2;

            if(numbers[mid]==k)
            {
                lowAns=mid;
                highIndex=mid-1;
            }
            else if(numbers[mid]>k)
            {
                highIndex=mid-1;
            }
            else
            {
                lowIndex=mid+1;
            }
        }

        lowIndex = 0;
        highIndex = numbers.length - 1;

        int highAns=-1;

        while(lowIndex<=highIndex)
        {
            c2++;
            int mid = (lowIndex+highIndex)/2;

            if(numbers[mid]==k)
            {
                highAns=mid;
                lowIndex=mid+1;
            }
            else if(numbers[mid]>k)
            {
                highIndex=mid-1;
            }
            else
            {
                lowIndex=mid+1;
            }
        }

        return highAns - lowAns + 1;
    }

    public static int binarySearch(int[] numbers, int k, int sIndex, int eIndex) {
        c++;
        if (sIndex > eIndex) {
            return -1;
        }

        int middleIndex = sIndex + (eIndex - sIndex) / 2;

        if (numbers[middleIndex] == k) {
            return middleIndex;
        }
        else if (numbers[middleIndex] > k) {
            return binarySearch(numbers, k, sIndex, middleIndex - 1);
        }
        else {
            return binarySearch(numbers, k, middleIndex + 1, eIndex);
        }
    }
}
