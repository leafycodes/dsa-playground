#include <bits/stdc++.h>
using namespace std;

// exponential recursion code
class Solution {
   public:
    int knapsack(int W, vector<int> &val, vector<int> &wt) {
        return helper(val, wt, W, wt.size());
    }

    int helper(vector<int> &val, vector<int> &wt, int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {
            int val1 = val[n - 1] + helper(val, wt, W - wt[n - 1], n - 1);
            int val2 = helper(val, wt, W, n - 1);

            return max(val1, val2);
        }

        return helper(val, wt, W, n - 1);
    }
};

// memoization - 2D array
class Solution {
   public:
    int knapsack(int W, vector<int> &val, vector<int> &wt) {
        vector<vector<int>> dp(W + 1, vector<int>(wt.size() + 1, -1));
        return helper(val, wt, W, wt.size(), dp);
    }

    int helper(vector<int> &val, vector<int> &wt, int W, int n,
               vector<vector<int>> &dp) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[W][n] != -1) {
            return dp[W][n];
        }

        if (wt[n - 1] <= W) {
            int val1 = val[n - 1] + helper(val, wt, W - wt[n - 1], n - 1, dp);
            int val2 = helper(val, wt, W, n - 1, dp);

            return dp[W][n] = max(val1, val2);
        }

        return dp[W][n] = helper(val, wt, W, n - 1, dp);
    }
};