import java.util.Arrays;
import java.util.Comparator;

class Solution {
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        // ratio - value/weight

        double[][] ratio = new double[values.length][2];
        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double) values[i] / weights[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(k -> -k[1]));

        int remaining = W;
        double profit = 0;

        for (int i = 0; i < ratio.length; i++) {
            int idx = (int) ratio[i][0];

            if (remaining > weights[idx]) {
                profit += values[idx];
                remaining -= weights[idx];
            } else {
                profit += (ratio[i][1] * remaining);
                remaining = 0;
                break;
            }
        }
        return profit;
    }
}