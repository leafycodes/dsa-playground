import java.util.Arrays;

class Solution {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });

        int dp[] = new int[n];
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1]
                        && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        return maxHeight;
    }
}