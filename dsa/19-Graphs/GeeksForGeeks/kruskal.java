// User function Template for Java

import java.util.Arrays;

class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        dsu uf = new dsu();
        uf.init(V);
        Arrays.sort(edges, (a, b) -> a[2] - b[2]); // O(ElogE)
        int finalCost = 0;
        int cnt = 0;

        for (int i = 0; cnt < V - 1; i++) { // can do i<edges.length but code will run a bit more then

            // O(V)
            int[] edge = edges[i];
            int parA = uf.find(edge[0]);
            int parB = uf.find(edge[1]);
            if (parA != parB) {
                uf.union(parA, parB);
                finalCost += edge[2];
                cnt++;
            }
        }

        return finalCost;
    }
}

class dsu {
    int n;
    int par[];
    int rank[];

    public void init(int V) {
        n = V;
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public int find(int x) {
        if (x == par[x]) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public void union(int x, int y) {
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
}