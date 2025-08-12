#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    void topSort(vector<vector<int>>& adj, int curr, vector<bool>& vis,
                 stack<int>& s) {
        vis[curr] = true;
        for (int ngbr : adj[curr]) {
            if (!vis[ngbr]) {
                topSort(adj, ngbr, vis, s);
            }
        }
        s.push(curr);
    }

    void dfs(vector<vector<int>>& adj, int curr, vector<bool>& vis) {
        vis[curr] = true;
        for (int ngbr : adj[curr]) {
            if (!vis[ngbr]) {
                dfs(adj, ngbr, vis);
            }
        }
    }

    int kosaraju(vector<vector<int>>& adj) {
        int n = adj.size();
        stack<int> s;
        vector<bool> vis(n, false);

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                topSort(adj, i, vis, s);
            }
        }

        vector<vector<int>> transpose(n);
        for (int i = 0; i < n; i++) {
            for (int j : adj[i]) {
                transpose[j].push_back(i);
            }
        }

        fill(vis.begin(), vis.end(), false);
        int cnt = 0;

        while (!s.empty()) {
            int curr = s.top();
            s.pop();
            if (!vis[curr]) {
                cnt++;
                dfs(transpose, curr, vis);
            }
        }

        return cnt;
    }
};