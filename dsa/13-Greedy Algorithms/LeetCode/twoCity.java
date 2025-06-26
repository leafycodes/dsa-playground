import java.util.Arrays;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            int c1 = a[1] - a[0];
            int c2 = b[1] - b[0];

            if (c1 < c2) {
                return 1;
            } else if (c1 > c2) {
                return -1;
            } else {
                return 0;
            }
        });

        int minCost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            minCost += costs[i][0];
        }

        for (int i = costs.length / 2; i < costs.length; i++) {
            minCost += costs[i][1];
        }

        return minCost;
    }
}