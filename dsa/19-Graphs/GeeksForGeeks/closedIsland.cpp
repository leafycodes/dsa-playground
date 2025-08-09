#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int closedIslands(vector<vector<int>>& matrix, int N, int M) {
        vector<vector<bool>> vis(N, vector<bool>(M, false));
        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i != 0 && j != 0 && i != N - 1 && j != M - 1 &&
                    matrix[i][j] == 1 && !vis[i][j]) {
                    bool has_corner_cell = false;
                    dfs(matrix, i, j, N, M, vis, has_corner_cell);
                    if (!has_corner_cell) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    void dfs(vector<vector<int>>& matrix, int x, int y, int n, int m,
             vector<vector<bool>>& vis, bool& has_corner_cell) {
        if (x < 0 || y < 0 || x >= n || y >= m || vis[x][y] ||
            matrix[x][y] == 0) {
            return;
        }

        if ((x == 0 || y == 0 || x == n - 1 || y == m - 1) &&
            matrix[x][y] == 1) {
            has_corner_cell = true;
        }

        vis[x][y] = true;
        dfs(matrix, x + 1, y, n, m, vis, has_corner_cell);
        dfs(matrix, x, y + 1, n, m, vis, has_corner_cell);
        dfs(matrix, x - 1, y, n, m, vis, has_corner_cell);
        dfs(matrix, x, y - 1, n, m, vis, has_corner_cell);
    }
};