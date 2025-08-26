class Solution {
    public int cutRod(int[] price) {
        int W = price.length;
        int dp[][] = new int[price.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = price[i - 1];
                int w = i;

                if (w <= j) {
                    dp[i][j] = Math.max(v + dp[i][j - w], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[price.length][W];
    }
}