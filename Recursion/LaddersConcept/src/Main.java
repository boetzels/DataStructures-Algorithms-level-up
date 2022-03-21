public class Main {

    public static void main(String[] args) {
	// write your code here
        int n = 4;
        int[] possibleSteps = {1, 2, 3};

        System.out.println(GetNbrWaysUp(n, possibleSteps));
    }

    public static int GetNbrWaysUp(int height, int[] possibleSteps) {
        if (height == 0) {
            return 1;
        }

        int ways = 0;
        for (int i : possibleSteps) {
            if (height - i >= 0) {
                ways += GetNbrWaysUp(height - i, possibleSteps);
            }
        }

        return ways;
    }
}
