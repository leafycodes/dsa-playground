import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int startCol = 0, startRow = 0, endRow = matrix.length - 1, endCol = matrix[0].length - 1;

        while (startCol <= endCol && startRow <= endRow) {
            for (int j = startCol; j <= endCol; j++) {
                res.add(matrix[startRow][j]);
            }

            for (int i = startRow + 1; i <= endRow; i++) {
                res.add(matrix[i][endCol]);
            }

            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                res.add(matrix[endRow][j]);
            }

            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                res.add(matrix[i][startCol]);
            }

            startCol++;
            startRow++;
            endRow--;
            endCol--;
        }

        return res;
    }
}