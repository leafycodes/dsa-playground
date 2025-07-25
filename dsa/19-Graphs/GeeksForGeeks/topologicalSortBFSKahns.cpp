#include <bits/stdc++.h>
using namespace std;

// this is the topological sort, but this time using BFS (Kahn's Algortihm)
class Solution {
   public:
    vector<int> topoSort(int V, vector<vector<int>>& edges) {
        vector<vector<int>> graph(V);
        for (vector<int> edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].push_back(v);
        }

        vector<int> in(V, 0);
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                int ngbr = graph[i][j];
                in[ngbr]++;
            }
        }

        queue<int> q;
        for (int i = 0; i < V; i++) {
            if (in[i] == 0) {
                q.push(i);
            }
        }

        // bfs code (only add the indegree 0 vertices to the queue)
        vector<int> res;
        while (!q.empty()) {
            int curr = q.front();
            q.pop();
            res.push_back(curr);

            for (int i = 0; i < graph[curr].size(); i++) {
                int ngbr = graph[curr][i];
                --in[ngbr];
                if (in[ngbr] == 0) {
                    q.push(ngbr);
                }
            }
        }

        return res;
    }
};