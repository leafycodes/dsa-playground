class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }

        return sell;
    }
}

// way 2 -> more intuitive
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] memo = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(prices, 0, 1, fee, memo);
    }

    private int helper(int[] prices, int i, int buy, int fee, int[][] memo) {
        if (i == prices.length) {
            return 0;
        }

        if (memo[i][buy] != -1) {
            return memo[i][buy];
        }

        int profit;
        if (buy == 1) {
            int take = -prices[i] + helper(prices, i + 1, 0, fee, memo);
            int leave = helper(prices, i + 1, 1, fee, memo);
            profit = Math.max(take, leave);
        } else {
            int sell = prices[i] - fee + helper(prices, i + 1, 1, fee, memo);
            int hold = helper(prices, i + 1, 0, fee, memo);
            profit = Math.max(sell, hold);
        }

        return memo[i][buy] = profit;
    }
}