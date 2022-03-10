import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //int[][] matrix = {{1, 4, 9}, {5, 6, 10}, {7, 8, 11}};
        int[][] matrix = {{1, 2, 10}, {3, 5, 11}, {4, 6, 13}};

        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Give element to search: ");

        int search = sc.nextInt();

        System.out.println(Arrays.toString(StaircaseSearch(matrix, search)));
    }

    public static int[] StaircaseSearch(int[][] matrix, int search) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;

        while (i < m && j >= 0) {
            if (matrix[i][j] == search) {
                return new int[]{i, j};
            }
            else if (matrix[i][j] > search) {
                j--;
            }
            else {
                i++;
            }
        }

        return new int[]{-1, -1};
    }
}
