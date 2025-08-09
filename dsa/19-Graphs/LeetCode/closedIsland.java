class Solution {
    public int closedIsland(int[][] grid) {
        int N = grid.length;
        if (N == 0) {
            return 0;
        }
        int M = grid[0].length;

        boolean[][] vis = new boolean[N][M];
        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i != 0 && j != 0 && i != N - 1 && j != M - 1 && grid[i][j] == 0 && !vis[i][j]) {
                    boolean[] hasCornerCell = new boolean[1];
                    dfs(grid, i, j, N, M, vis, hasCornerCell);
                    if (!hasCornerCell[0]) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int x, int y, int n, int m, boolean[][] vis, boolean[] hasCornerCell) {
        if (x < 0 || y < 0 || x >= n || y >= m || vis[x][y] || grid[x][y] == 1) {
            return;
        }

        if ((x == 0 || y == 0 || x == n - 1 || y == m - 1) && grid[x][y] == 0) {
            hasCornerCell[0] = true;
        }

        vis[x][y] = true;
        dfs(grid, x + 1, y, n, m, vis, hasCornerCell);
        dfs(grid, x, y + 1, n, m, vis, hasCornerCell);
        dfs(grid, x - 1, y, n, m, vis, hasCornerCell);
        dfs(grid, x, y - 1, n, m, vis, hasCornerCell);
    }
}