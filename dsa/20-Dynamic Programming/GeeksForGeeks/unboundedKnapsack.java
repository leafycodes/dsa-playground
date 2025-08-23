class Solution {
    static int knapSack(int val[], int wt[], int W) {
        int dp[][] = new int[wt.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];

                if (w <= j) {
                    dp[i][j] = Math.max(v + dp[i][j - w], dp[i - 1][j]); // dp[i][j-w] and not dp[i-1][j-w] as that in
                                                                         // 01 knapsack, rest all same
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[wt.length][W];
    }
}
