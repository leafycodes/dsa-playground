import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int steps = nums[i];
            int res = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + steps && j < n; j++) {
                if (dp[j] != -1) {
                    res = Math.min(res, dp[j] + 1);
                }
            }

            if (res != Integer.MAX_VALUE) {
                dp[i] = res;
            }
        }

        return dp[0];
    }
}