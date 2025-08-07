#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    void dfs(vector<int> adj[], int curr, vector<bool>& vis) {
        vis[curr] = true;

        for (int ngbr : adj[curr]) {
            if (!vis[ngbr]) {
                dfs(adj, ngbr, vis);
            }
        }
    }

    // Function to find a Mother Vertex in the Graph.
    int findMotherVertex(int V, vector<int> adj[]) {
        // Code here
        vector<bool> vis(V, false);
        int mom = -1;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis);
                mom = i;
            }
        }

        vector<bool> check(V, false);
        dfs(adj, mom, check);

        for (int el : check) {
            if (!el) {
                return -1;
            }
        }

        return mom;
    }
};