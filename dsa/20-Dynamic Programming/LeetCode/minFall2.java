class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = Integer.MAX_VALUE;

                for (int k = 0; k < m; k++) {
                    if (k != j) {
                        sum = Math.min(sum, dp[i - 1][k]);
                    }
                }

                dp[i][j] = matrix[i][j] + sum;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }

        return res;
    }
}