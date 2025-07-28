class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    cnt = 1;
                    dfs(grid, i, j, vis);
                    res = Math.max(res, cnt);
                }
            }
        }

        return res;
    }

    private int cnt = 1;

    private void dfs(int[][] grid, int row, int col, boolean[][] vis) {
        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        vis[row][col] = true;
        for (int dir[] : directions) {
            int dx = row + dir[0];
            int dy = col + dir[1];

            if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && grid[dx][dy] == 1 && !vis[dx][dy]) {
                ++cnt;
                dfs(grid, dx, dy, vis);
            }
        }
    }
}