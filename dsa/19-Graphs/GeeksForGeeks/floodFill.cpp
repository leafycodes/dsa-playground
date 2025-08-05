// was there in my LGSI interview, did in java in leetcode -> here i am with cpp
// and gfg

// i did that one in bfs, you can check the /tech-rounds folders for that soln.
// here, we use a dfs approach
#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc,
                                  int newColor) {
        vector<vector<bool>> vis(image.size(),
                                 vector<bool>(image[0].size(), false));
        dfs(image, sr, sc, newColor, vis, image[sr][sc]);
        return image;
    }

    void dfs(vector<vector<int>>& image, int sr, int sc, int newColor,
             vector<vector<bool>>& vis, int orgColor) {
        if (sr < 0 || sc < 0 || sr >= image.size() || sc >= image[0].size() ||
            vis[sr][sc] || image[sr][sc] != orgColor) {
            return;
        }

        vis[sr][sc] = true;
        image[sr][sc] = newColor;

        dfs(image, sr, sc - 1, newColor, vis, orgColor);
        dfs(image, sr, sc + 1, newColor, vis, orgColor);
        dfs(image, sr + 1, sc, newColor, vis, orgColor);
        dfs(image, sr - 1, sc, newColor, vis, orgColor);
    }
};