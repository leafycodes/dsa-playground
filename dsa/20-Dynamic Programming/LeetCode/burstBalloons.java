import java.util.Arrays;

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        return helper(0, n - 1, nums, dp);
    }

    private int helper(int i, int j, int nums[], int dp[][]) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = 0;
        for (int k = i; k <= j; k++) {
            int left = helper(i, k - 1, nums, dp);
            int right = helper(k + 1, j, nums, dp);
            int val = nums[k];

            if (i - 1 >= 0) {
                val *= nums[i - 1];
            }

            if (j + 1 <= nums.length - 1) {
                val *= nums[j + 1];
            }

            int cost = left + right + val;
            res = Math.max(res, cost);
        }

        return dp[i][j] = res;
    }
}