#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        auto comp = [](const pair<int, int>& a, const pair<int, int>& b) {
            return a.first * a.first + a.second * a.second <
                   b.first * b.first + b.second * b.second;
        };

        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(comp)>
            pq(comp);
        for (auto point : points) {
            pq.push({point[0], point[1]});
        }

        vector<vector<int>> res;
        for (int i = 0; i < k; i++) {
            auto curr = pq.top();
            pq.pop();
            res.push_back({curr.first, curr.second});
        }

        return res;
    }
};