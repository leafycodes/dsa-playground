class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp1[i] = dp2[i] = -1;
        }

        return Math.max(helper(0, nums.length - 2, nums, dp1), helper(1, nums.length - 1, nums, dp2));
    }

    private int helper(int i, int n, int nums[], int[] dp) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return nums[i];
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = Math.max(nums[i] + helper(i + 2, n, nums, dp), helper(i + 1, n, nums, dp));
        return dp[i];
    }
}