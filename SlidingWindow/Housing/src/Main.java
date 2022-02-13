import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer[] numbers = {1,3,2,1,4,1,3,2,1,1,2};
        int k = 8;

        ArrayList<Integer[]> result = getHousing(numbers, k);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(Arrays.asList(result.get(i)));
        }
    }

    private static ArrayList<Integer[]> getHousing(Integer[] plots, int desiredSize) {
        ArrayList<Integer[]> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        int actualSum = plots[i];
        while (i < plots.length) {
            if (desiredSize == actualSum) {
                result.add(new Integer[]{j,i});
            }
            if (desiredSize < actualSum) {
                actualSum -= plots[j++];
            }
            else if (++i < plots.length) {
                actualSum += plots[i];
            }
        }

        return result;
    }
}
