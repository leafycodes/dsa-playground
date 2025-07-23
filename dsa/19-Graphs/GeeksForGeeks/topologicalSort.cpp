#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    vector<int> topoSort(int V, vector<vector<int>>& edges) {
        vector<vector<int>> graph(V);
        for (vector<int> edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].push_back(v);
        }

        vector<bool> vis(graph.size());
        stack<int> st;

        for (int i = 0; i < graph.size(); i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, st);
            }
        }

        vector<int> res;
        while (!st.empty()) {
            res.push_back(st.top());
            st.pop();
        }

        return res;
    }

   private:
    void dfs(vector<vector<int>>& graph, int& curr, vector<bool>& vis,
             stack<int>& st) {
        vis[curr] = true;
        for (int ngbr : graph[curr]) {
            if (!vis[ngbr]) {
                dfs(graph, ngbr, vis, st);
            }
        }

        st.push(curr);
    }
};