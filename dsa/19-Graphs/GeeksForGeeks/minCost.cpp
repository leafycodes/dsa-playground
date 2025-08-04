#include <cmath>
#include <iostream>
#include <queue>
#include <utility>
#include <vector>
using namespace std;

class compare {
   public:
    bool operator()(const pair<int, int>& a, const pair<int, int>& b) {
        return a.second > b.second;
    }
};

class Solution {
   public:
    int minCost(vector<vector<int>>& houses) {
        priority_queue<pair<int, int>, vector<pair<int, int>>, compare> pq;
        vector<bool> vis(houses.size(), false);
        pq.push({0, 0});
        int final_cost = 0;

        while (!pq.empty()) {
            pair<int, int> curr = pq.top();
            pq.pop();

            if (!vis[curr.first]) {
                vis[curr.first] = true;
                final_cost += curr.second;

                for (int i = 0; i < houses.size(); i++) {
                    if (!vis[i]) {
                        int cost = abs(houses[curr.first][0] - houses[i][0]) +
                                   abs(houses[curr.first][1] - houses[i][1]);
                        pq.push({i, cost});
                    }
                }
            }
        }

        return final_cost;
    }
};