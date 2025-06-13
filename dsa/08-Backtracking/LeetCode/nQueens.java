import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0 || n == 1) {
            res.add(new ArrayList<>(Arrays.asList("Q")));
            return res;
        }
        if (n == 2 || n == 3) {
            return new ArrayList<>();
        }
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }
        nQueens(board, 0);
        return res;
    }

    private void nQueens(List<String> board, int row) {
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            if (isSafe(board, row, col)) {
                String currRow = board.get(row);
                String newRow = currRow.substring(0, col) + "Q" + currRow.substring(col + 1);
                board.set(row, newRow); // put Q instead of .
                nQueens(board, row + 1); // function call
                board.set(row, currRow); // put . back and remove Q
            }
        }
    }

    private boolean isSafe(List<String> board, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}