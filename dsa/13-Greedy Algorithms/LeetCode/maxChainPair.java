import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparing(k -> k[1]));

        if (pairs.length < 1) {
            return 0;
        }

        int count = 1;
        int lastselected = pairs[0][1];
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] > lastselected) {
                count++;
                lastselected = pairs[i][1];
            }
        }

        return count;
    }
}