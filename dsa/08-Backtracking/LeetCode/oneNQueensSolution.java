import java.util.ArrayList;
import java.util.List;

public class oneNQueensSolution {
    private static List<String> solution;

    public static List<String> solveNQueens(int n) {
        if (n == 0 || n == 1) {
            return new ArrayList<>();
        }
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }
        if (nQueens(board, 0)) {
            solution = new ArrayList<>(board);
            return solution;
        }
        return new ArrayList<>();
    }

    private static boolean nQueens(List<String> board, int row) {
        if (row == board.size()) {
            return true;
        }

        for (int col = 0; col < board.size(); col++) {
            if (isSafe(board, row, col)) {
                String currRow = board.get(row);
                String newRow = currRow.substring(0, col) + "Q" + currRow.substring(col + 1);
                board.set(row, newRow); // put Q instead of .
                if (nQueens(board, row + 1)) {
                    return true;
                } // function call
                  // Backtrack
                board.set(row, currRow); // undo the queen placement
            }
        }
        return false;
    }

    private static boolean isSafe(List<String> board, int row, int col) {
        // Check column
        for (int i = row - 1; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        List<String> solution = solveNQueens(n);

        if (solution.isEmpty()) {
            System.out.println("No solution exists for n = " + n);
        } else {
            for (String row : solution) {
                System.out.println(row);
            }
        }
    }
}