import java.util.Arrays;

class Solution {
    public static int findCatalan(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int res = 0;
        for (int i = 0; i <= n - 1; i++) {
            res += findCatalan(i) * findCatalan(n - i - 1);
        }

        return res;
    }
}

// the above code is TLE, very over-the-head amount of function calls

// memoization DP, a slightly better approach

class Solution2 {
    public static int findCatalan(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    private static int helper(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int res = 0;
        for (int i = 0; i <= n - 1; i++) {
            res += helper(i, dp) * helper(n - i - 1, dp);
        }

        return dp[n] = res;
    }
}

// the above memo works, but here is a tabulation for a better complexity

// tabulation DP, a more better approach

class Solution2b {
    public static int findCatalan(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
}
