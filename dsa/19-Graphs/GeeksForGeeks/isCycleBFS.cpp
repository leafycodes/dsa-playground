#include <iostream>
#include <queue>
#include <utility>
#include <vector>
using namespace std;

class Solution {
   public:
    bool bfs(vector<vector<int>>& graph, int start, vector<bool>& vis) {
        queue<pair<int, int>> q;  // (current node, parent node)
        q.push({start, -1});
        vis[start] = true;

        while (!q.empty()) {
            int curr = q.front().first;
            int par = q.front().second;
            q.pop();

            for (int ngbr : graph[curr]) {
                if (!vis[ngbr]) {
                    vis[ngbr] = true;
                    q.push({ngbr, curr});
                } else if (vis[ngbr] && ngbr != par) {
                    return true;
                }
            }
        }
        return false;
    }

    bool isCycle(int V, vector<vector<int>>& edges) {
        vector<vector<int>> graph(V);
        for (vector<int> edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].push_back(v);
            graph[v].push_back(u);
        }

        vector<bool> vis(V, false);
        for (int i = 0; i < graph.size(); i++) {
            if (!vis[i]) {
                if (bfs(graph, i, vis)) {
                    return true;
                }
            }
        }

        return false;
    }
};