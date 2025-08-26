import java.util.Arrays;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2, text1.length(), text2.length());
    }

    private int helper(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return 1 + helper(str1, str2, n - 1, m - 1);
        } else {
            return Math.max(helper(str1, str2, n - 1, m), helper(str1, str2, n, m - 1));
        }
    }
}

// memoization DP
class Solution2a {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(text1, text2, text1.length(), text2.length(), dp);
    }

    private int helper(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = 1 + helper(str1, str2, n - 1, m - 1, dp);
        } else {
            return dp[n][m] = Math.max(helper(str1, str2, n - 1, m, dp), helper(str1, str2, n, m - 1, dp));
        }
    }
}

// tabulation DP
class Solution2b {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}