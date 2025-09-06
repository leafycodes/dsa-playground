// longest increasing path in matrix

import java.util.Arrays;

public class LIP {
    public static void main(String[] args) {
        int grid[][] = { { 1, 2, 3, 4 }, { 2, 2, 3, 4 }, { 3, 2, 3, 4 }, { 4, 5, 6, 7 } };

        System.out.println(length(grid));
    }

    private static int length(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (m == 0 && n == 0) {
            return 0;
        }

        int dp[][] = new int[m][n];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        return helper(dp, grid, 0, 0);
    }

    private static int helper(int dp[][], int grid[][], int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int path = 1;
        if (j < grid[0].length - 1 && grid[i][j] < grid[i][j + 1]) {
            path = Math.max(path, 1 + helper(dp, grid, i, j + 1));
        }

        if (i < grid.length - 1 && grid[i][j] < grid[i + 1][j]) {
            path = Math.max(path, 1 + helper(dp, grid, i + 1, j));
        }

        return dp[i][j] = path;
    }
}
