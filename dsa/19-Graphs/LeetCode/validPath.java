import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // TLE using edges directly: so i built an adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        } // empty arraylist init

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // it is undirected
        }

        boolean[] vis = new boolean[n];
        return dfs(adj, source, destination, vis);
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> graph, int src, int dst, boolean[] vis) {
        if (src == dst) {
            return true;
        }

        vis[src] = true;
        for (int i = 0; i < graph.get(src).size(); i++) {
            int nbr = graph.get(src).get(i);
            if (!vis[nbr] && dfs(graph, nbr, dst, vis)) {
                return true;
            }
        }

        return false;
    }
}

// the below code will give TLE: why? we have to find the vertices for every
// edge, making it kind of slow -> at this point rather use an adjacency list
// than sticking with the 2d matrix (remember to add undirected edges to the
// list)

// class Solution {
// public boolean validPath(int n, int[][] edges, int source, int destination) {
// boolean[] vis = new boolean[n];
// return dfs(edges, source, destination, vis);
// }

// private boolean dfs(int[][] edges, int src, int dst, boolean[] vis) {
// if (src == dst) {
// return true;
// }
// vis[src] = true;
// for (int[] edge : edges) {
// int u = edge[0];
// int v = edge[1];
// if (u == src && !vis[v]) {
// if (dfs(edges, v, dst, vis)) {
// return true;
// }
// } else if (v == src && !vis[u]) {
// if (dfs(edges, u, dst, vis)) {
// return true;
// }
// }
// }
// return false;
// }
// }