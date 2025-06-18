class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }

        int n = grid.length;
        int[][] positions = new int[n * n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                positions[grid[i][j]][0] = i;
                positions[grid[i][j]][1] = j;
            }
        }

        for (int i = 0; i < n * n - 1; i++) {
            int[] currCell = positions[i];
            int[] nextCell = positions[i + 1];

            int dx = Math.abs(currCell[0] - nextCell[0]);
            int dy = Math.abs(currCell[1] - nextCell[1]);

            if (!((dx == 1 && dy == 2) || (dx == 2 && dy == 1))) {
                return false;
            }
        }
        return true;
    }
}