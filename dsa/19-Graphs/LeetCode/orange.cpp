#include <iostream>
#include <queue>
#include <utility>
#include <vector>
using namespace std;

class Solution {
   public:
    int orangesRotting(vector<vector<int>>& grid) {
        int fresh = 0;
        int time = 0;
        queue<pair<int, int>> q;

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[i].size(); j++) {
                if (grid[i][j] == 1) {
                    ++fresh;
                } else if (grid[i][j] == 2) {
                    q.push({i, j});
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        vector<vector<int>> directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.empty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                pair<int, int> curr = q.front();
                q.pop();

                for (vector<int>& dir : directions) {
                    int dx = curr.first + dir[0];
                    int dy = curr.second + dir[1];

                    if (dx >= 0 && dx < grid.size() && dy >= 0 &&
                        dy < grid[0].size() && grid[dx][dy] == 1) {
                        grid[dx][dy] = 2;
                        --fresh;
                        q.push({dx, dy});
                    }
                }
            }

            if (!q.empty()) {
                ++time;
            }
        }

        return fresh == 0 ? time : -1;
    }
};