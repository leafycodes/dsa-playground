class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int memo[][][] = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return helper(0, strs, m, n, memo);
    }

    private int helper(int i, String[] strs, int m, int n, int memo[][][]) {
        if (i >= strs.length || m < 0 || n < 0) {
            return 0;
        }

        if (memo[i][m][n] != -1) {
            return memo[i][m][n];
        }

        int cz = 0, co = 0;
        for (int k = 0; k < strs[i].length(); k++) {
            if (strs[i].charAt(k) == '0') {
                cz++;
            } else {
                co++;
            }
        }

        if (cz > m || co > n) {
            memo[i][m][n] = helper(i + 1, strs, m, n, memo);
        } else {
            int take = 1 + helper(i + 1, strs, m - cz, n - co, memo);
            int leave = helper(i + 1, strs, m, n, memo);
            memo[i][m][n] = Math.max(take, leave);
        }

        return memo[i][m][n];
    }
}