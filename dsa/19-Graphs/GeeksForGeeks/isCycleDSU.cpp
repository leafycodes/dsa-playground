#include <bits/stdc++.h>
using namespace std;

class DSU {
   private:
    int n;
    vector<int> par;
    vector<int> rank;

   public:
    void init(int V) {
        n = V;
        for (int i = 0; i < n; i++) {
            par.push_back(i);
            rank.push_back(0);
        }
    }

    int find(int x) {
        if (par[x] == x) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    void unionSet(int x, int z) {
        int px = find(x);
        int pz = find(z);

        if (rank[px] == rank[pz]) {
            par[px] = pz;
            rank[pz]++;
        } else if (rank[px] > rank[pz]) {
            par[pz] = px;
        } else {
            par[px] = pz;
        }
    }
};

class Solution {
   public:
    bool isCycle(int V, vector<vector<int>>& edges) {
        DSU uf;
        uf.init(V);

        for (const auto& edge : edges) {
            int pu = uf.find(edge[0]);
            int pv = uf.find(edge[1]);

            if (pu == pv) {
                return true;
            } else {
                uf.unionSet(pu, pv);
            }
        }

        return false;
    }
};