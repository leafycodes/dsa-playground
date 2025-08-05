#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int time;

    vector<int> articulationPoints(int V, vector<vector<int>>& edges) {
        vector<vector<int>> adj(V);
        for (vector<int>& edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        vector<bool> vis(V, false);
        vector<int> disc(V);
        vector<int> low(V);
        vector<bool> isAP(V, false);
        time = 0;
        int par = -1;

        for (int u = 0; u < V; u++) {
            if (!vis[u]) {
                dfs(adj, u, vis, disc, low, par, isAP);
            }
        }

        vector<int> res;
        for (int u = 0; u < V; u++) {
            if (isAP[u]) {
                res.push_back(u);
            }
        }

        if (res.empty()) {
            return {-1};
        }

        return res;
    }

    void dfs(vector<vector<int>>& adj, int u, vector<bool>& vis,
             vector<int>& disc, vector<int>& low, int parent,
             vector<bool>& isAP) {
        int child = 0;
        vis[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj[u]) {
            if (!vis[v]) {
                child++;
                dfs(adj, v, vis, disc, low, u, isAP);
                low[u] = min(low[u], low[v]);

                if (parent != -1 && low[v] >= disc[u]) {
                    isAP[u] = true;
                }
            } else if (v != parent) {
                low[u] = min(low[u], disc[v]);
            }
        }

        if (parent == -1 && child > 1) {
            isAP[u] = true;
        }
    }
};