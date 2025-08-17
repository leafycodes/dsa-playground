//recursion
class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}

// memoization
class Solution2 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int dp[] = new int[n + 1];
        dp[1] = 1;

        return helper(n, dp);
    }

    private int helper(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
    }
}

// tabulation
class Solution3 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int dp[] = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}