import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        if (start.length == 0) {
            return 0;
        }

        int activities[][] = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = finish[i];
        }

        Arrays.sort(activities, Comparator.comparingInt(k -> k[2]));

        int max = 0;
        int lastFinish = Integer.MIN_VALUE;

        for (int i = 0; i < start.length; i++) {
            if (activities[i][1] > lastFinish) {
                max++;
                lastFinish = activities[i][2];
            }
        }

        return max;
    }
}
