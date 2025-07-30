#include <bits/stdc++.h>
using namespace std;

class compare {
   public:
    bool operator()(const pair<int, int>& a, const pair<int, int>& b) {
        return a.second > b.second;
    }
};

class Solution {
   public:
    // Function to find sum of weights of edges of the Minimum Spanning Tree.
    int spanningTree(int V, vector<vector<int>> edges[]) {
        vector<vector<int>> graph(V);
        vector<bool> vis(V, false);
        priority_queue<pair<int, int>, vector<pair<int, int>>, compare>
            pq;  // vertex, cost
        pq.push({0, 0});
        int cost = 0;

        while (!pq.empty()) {
            pair<int, int> curr = pq.top();
            pq.pop();

            if (!vis[curr.first]) {
                vis[curr.first] = true;
                cost += curr.second;

                for (int i = 0; i < edges[curr.first].size(); i++) {
                    int ngbr = edges[curr.first][i][0];
                    int wt = edges[curr.first][i][1];
                    pq.push({ngbr, wt});
                }
            }
        }

        return cost;
    }
};