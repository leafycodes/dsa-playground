// User function Template for Java

import java.util.ArrayList;

class Solution {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }
        nQueens(board, 0);
        return res;
    }

    private void nQueens(ArrayList<String> board, int row) {
        if (row == board.size()) {
            ArrayList<Integer> cols = new ArrayList<>();
            for (int i = 0; i < board.size(); i++) {
                String s = board.get(i);
                cols.add(s.indexOf("Q") + 1);
            }
            res.add(cols);
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            if (isSafe(board, row, col)) {
                String currRow = board.get(row);
                String newRow = board.get(row).substring(0,
                        col) + "Q" + board.get(row).substring(col + 1);
                board.set(row, newRow);
                nQueens(board, row + 1);
                board.set(row, currRow);
            }
        }
    }

    private boolean isSafe(ArrayList<String> board, int row, int col) {
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
