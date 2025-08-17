//recursion gives TLE
// memoization

class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        return ways(n, dp);
    }

    private int ways(int n, int dp[]) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = ways(n - 1, dp) + ways(n - 2, dp);
    }
}

// tabulation
class Solution2a {
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }

        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

// tabulation - diff way to write
class Solution2b {
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];
    }
}