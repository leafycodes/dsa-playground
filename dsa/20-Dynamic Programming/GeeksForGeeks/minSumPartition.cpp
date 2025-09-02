#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int minDifference(vector<int>& arr) {
        int n = arr.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int w = sum / 2;
        vector<vector<int>> dp(n + 1, vector<int>(w + 1, 0));

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = max(arr[i - 1] + dp[i - 1][j - arr[i - 1]],
                                   dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int sum1 = dp[n][w];
        int sum2 = sum - sum1;
        return abs(sum1 - sum2);
    }
};
