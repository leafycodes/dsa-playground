import java.util.Arrays;

public class knightsTour {
    public static void main(String[] args) {
        int n = 8;
        int sol[][] = new int[n][n];
        for (int[] row : sol) {
            Arrays.fill(row, -1);
        }
        sol[0][0] = 0;

        if (knightsPath(0, 0, 1, n, sol)) {
            printSoln(sol);
        } else {
            System.out.println("no soln");
        }

    }

    private static void printSoln(int nums[][]) {
        for (int[] row : nums) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // this is one optimal order of moves. dont palce all clockwise or anticlockwise
    // or random, it'll take more time. this order takes leser time
    static int[][] moves = { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };

    private static boolean knightsPath(int row, int col, int i, int n, int[][] sol) {
        if (i == n * n) {
            return true;
        }

        for (int k = 0; k < 8; k++) {
            int newRow = row + moves[k][0];
            int newCol = col + moves[k][1];
            if (isValid(newRow, newCol, sol)) {
                sol[newRow][newCol] = i;
                if (knightsPath(newRow, newCol, i + 1, n, sol)) {
                    return true;
                }
                sol[newRow][newCol] = -1;
            }
        }
        return false;
    }

    private static boolean isValid(int row, int col, int[][] sol) {
        return (row >= 0 && row < sol.length && col >= 0 && col < sol.length && sol[row][col] == -1);
    }
}
