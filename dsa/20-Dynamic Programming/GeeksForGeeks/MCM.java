// matrix chain multiplication

import java.util.Arrays;

class Solution {
    static int matrixMultiplication(int arr[]) {
        return mcm(arr, 1, arr.length - 1);
    }

    private static int mcm(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost1 = mcm(arr, i, k);
            int cost2 = mcm(arr, k + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;
            res = Math.min(res, finalCost);
        }

        return res;
    }
}

// the above one is highly unoptimized, yet passes 1110/1111 cases on GfG

// here is the memo dp
class Solution2 {
    static int matrixMultiplication(int arr[]) {
        int dp[][] = new int[arr.length][arr.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return mcm(arr, 1, arr.length - 1, dp);
    }

    private static int mcm(int[] arr, int i, int j, int dp[][]) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost1 = mcm(arr, i, k, dp);
            int cost2 = mcm(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;
            res = Math.min(res, finalCost);
        }

        return dp[i][j] = res;
    }
}

// memo works just fine, but here is the tabulation for clarity

// tabulation dp
class Solution2b {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        if (n == 0 || n == 1) {
            return 0;
        }

        int dp[][] = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];

                    int finalCost = cost1 + cost2 + cost3;
                    dp[i][j] = Math.min(dp[i][j], finalCost);
                }
            }
        }

        return dp[1][n - 1];
    }
}