class Solution {
    private static final int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }
        return maxGold;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int currentGold = grid[i][j];
        grid[i][j] = 0;
        int maxGold = 0;

        for (int[] dir : directions) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            maxGold = Math.max(maxGold, dfs(grid, newX, newY));
        }

        grid[i][j] = currentGold;
        return currentGold + maxGold;
    }
}