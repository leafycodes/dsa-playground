#include <bits/stdc++.h>
using namespace std;

class DSU {
   private:
    int n;
    vector<int> par;
    vector<int> rank;

   public:
    void init(int V) {
        this->n = V;
        this->rank.resize(n, 0);
        for (int i = 0; i < n; i++) {
            par.push_back(i);
        }
    }

    int find(int x) {
        if (x == par[x]) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    void unionSet(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (rank[px] == rank[py]) {
            par[py] = px;
            rank[px]++;
        } else if (rank[px] < rank[py]) {
            par[px] = py;
        } else {
            par[py] = px;
        }
    }
};

class Solution {
   public:
    int kruskalsMST(int V, vector<vector<int>>& edges) {
        DSU uf;
        uf.init(V);
        sort(edges.begin(), edges.end(),
             [](const vector<int>& x, const vector<int>& y) {
                 return x[2] < y[2];
             });
        int cost = 0;
        int cnt = 0;
        for (int i = 0; cnt < V - 1; i++) {
            vector<int> edge = edges[i];
            int px = uf.find(edge[0]);
            int py = uf.find(edge[1]);

            if (px != py) {
                uf.unionSet(px, py);
                cost += edge[2];
                cnt++;
            }
        }

        return cost;
    }
};