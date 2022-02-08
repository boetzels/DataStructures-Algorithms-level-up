import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer[][] schedule = {{7,9},{0,10},{4,5},{8,9},{4,10},{5,7}};

        System.out.println(getMaxNumOfActivities(schedule));
    }

    public static int getMaxNumOfActivities(Integer[][] schedule) {
        Arrays.sort(schedule, Comparator.comparingInt(o -> o[0]));

        int numOfActivities = 0;
        int lastEnding = 0;
        for (int i = 0; i < schedule.length; i++) {
            if (lastEnding <= schedule[i][0]) {
                lastEnding = schedule[i][1];
                numOfActivities++;
            }
            else if (lastEnding > schedule[i][1]) {
                lastEnding = schedule[i][1];
            }
        }
        return numOfActivities;
    }
}
