class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        return helper(nums.length - 1, nums);
    }

    private int helper(int n, int nums[]) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return nums[0];
        }

        int val1 = helper(n - 1, nums);
        int val2 = nums[n] + helper(n - 2, nums);

        return Math.max(val1, val2);
    }
}

// memoization dp -> still TLE for 3 cases
class Solution2a {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int dp[] = new int[101];
        return helper(nums.length - 1, nums, dp);
    }

    private int helper(int n, int nums[], int[] dp) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return nums[0];
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int val1 = helper(n - 1, nums, dp);
        int val2 = nums[n] + helper(n - 2, nums, dp);

        return dp[n] = Math.max(val1, val2);
    }
}

// tabulation dp -> AC
class Solution2b {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int dp[] = new int[101];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                dp[i] = Math.max(dp[i - 1], nums[i]);
                continue;
            }
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[nums.length - 1];
    }
}

// tabualtion reverse
class Solution4 {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        }

        dp[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (i == n - 2) {
                dp[i] = Math.max(dp[i + 1], nums[i]);
                continue;
            }

            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }

        return dp[0];
    }
}