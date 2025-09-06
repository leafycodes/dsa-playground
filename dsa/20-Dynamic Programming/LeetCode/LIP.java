import java.util.Arrays;

class Solution {
    int directions[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 0 || n == 0) {
            return 0;
        }

        int dp[][] = new int[m][n];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        int maxPath = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxPath = Math.max(maxPath, dfs(dp, matrix, i, j));
            }
        }

        return maxPath;
    }

    private int dfs(int[][] dp, int grid[][], int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int path = 1; // curr cell is min path
        for (int[] dir : directions) {
            int dx = i + dir[0];
            int dy = j + dir[1];

            if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && grid[i][j] < grid[dx][dy]) {
                path = Math.max(path, 1 + dfs(dp, grid, dx, dy));
            }
        }

        return dp[i][j] = path;
    }
}