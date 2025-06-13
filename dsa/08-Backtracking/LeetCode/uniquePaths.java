import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return countWays(0, 0, m, n, dp);
    }

    private int countWays(int i, int j, int m, int n, int[][] dp) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        } else if (i == m || j == n) {
            return 0;
        }

        if (dp[i][j] == -1) {
            return dp[i][j] = countWays(i + 1, j, m, n, dp) + countWays(i, j + 1, m, n, dp);
        }
        return dp[i][j];
    }
}