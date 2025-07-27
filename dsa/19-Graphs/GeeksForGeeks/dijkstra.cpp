#include <bits/stdc++.h>
#define pii pair<int, int>
using namespace std;

class compare {
   public:
    bool operator()(const pii& a, const pii& b) { return a.second > b.second; }
};

class Solution {
   public:
    vector<int> dijkstra(int V, vector<vector<int>>& edges, int src) {
        vector<vector<pii>> graph(V);
        for (const auto& edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            graph[u].push_back({v, wt});
        }

        vector<int> dist(V, INT_MAX);
        dist[src] = 0;
        vector<bool> vis(V, false);
        priority_queue<pii, vector<pii>, compare> pq;
        pq.push({src, 0});

        // bfs loop
        while (!pq.empty()) {
            pii curr = pq.top();
            pq.pop();

            if (!vis[curr.first]) {
                vis[curr.first] = true;
                for (int i = 0; i < graph[curr.first].size(); i++) {
                    int u = curr.first;
                    int v = graph[curr.first][i].first;
                    int wt = graph[curr.first][i].second;
                    if (dist[v] > dist[u] + wt) {
                        dist[v] = dist[u] + wt;
                        pq.push({v, dist[v]});
                    }
                }
            }
        }

        return dist;
    }
};