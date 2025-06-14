import java.util.ArrayList;
import java.util.Collections;

class Solution {
    // Function to find all possible paths
    ArrayList<String> res = new ArrayList<>();
    int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    char[] dirChars = { 'R', 'D', 'L', 'U' };

    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
        int[][] soln = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                soln[i][j] = maze[i][j] == 1 ? -1 : 0;
            }
        }
        soln[0][0] = 1;
        gridWays(0, 0, new StringBuilder(), soln);
        Collections.sort(res);
        return res;
    }

    private void gridWays(int row, int col, StringBuilder currStr, int[][] soln) {
        int n = soln.length;

        if (row == n - 1 && col == n - 1) {
            res.add(currStr.toString());
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            if (isValid(newRow, newCol, soln)) {
                soln[row][col] = 1;
                currStr.append(dirChars[i]);

                gridWays(newRow, newCol, currStr, soln);

                soln[row][col] = -1;
                currStr.deleteCharAt(currStr.length() - 1);
            }
        }
    }

    private boolean isValid(int row, int col, int[][] soln) {
        int n = soln.length;
        return (row >= 0 && row < n && col >= 0 && col < n && soln[row][col] == -1);
    }
}