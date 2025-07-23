import java.util.*;

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // the given is an edge list, not an adjaceny list or adjaceny matrix
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[V];
        boolean[] stack = new boolean[V]; // mimic stack explicitly

        for (int i = 0; i < V; i++) {
            if (!vis[i] && helper(adj, i, vis, stack)) {
                return true;
            }
        }
        return false;
    }

    private boolean helper(List<List<Integer>> adj, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;

        for (int ngbr : adj.get(curr)) {
            if (stack[ngbr]) {
                return true;
            }
            if (!vis[ngbr] && helper(adj, ngbr, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false; // backtrack
        return false;
    }
}