class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(board, i, j, board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char digit) {
        for (int j = 0; j < 9; j++) {
            if (j != col && board[row][j] == digit) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == digit) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (i != row && j != col && board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }
}