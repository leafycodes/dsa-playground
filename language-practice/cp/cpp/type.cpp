#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    bool is_valid(vector<vector<int>>& image, int& row, int& col, int& color) {
        return row >= 0 && row < image.size() && col >= 0 &&
               col < image[0].size() && image[row][col] == color;
    }

    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc,
                                  int color) {
        // add the pixels to the queue
        // add it's adjacent to the queue
        // remove from queue and color it
        // case 1: 1st time we come
        // case 2: not 1st time
        queue<pair<int, int>> q;
        q.push({sr, sc});
        pair<int, int> directions[] = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        while (!q.empty()) {
            auto curr = q.front();
            q.pop();

            if (image[curr.first][curr.second] == color) {
                continue;
            }

            int temp_color = image[curr.first][curr.second];
            image[curr.first][curr.second] = color;

            for (auto dir : directions) {
                int dx = curr.first + dir.first;
                int dy = curr.second + dir.second;

                if (is_valid(image, dx, dy, temp_color)) {
                    q.push({dx, dy});
                }
            }
        }

        return image;
    }
};

int main() { return 0; }