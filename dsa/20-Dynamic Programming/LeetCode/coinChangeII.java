class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                int coin = coins[i - 1];
                if (coin <= j) {
                    dp[i][j] = dp[i][j - coin] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length][amount];
    }
}