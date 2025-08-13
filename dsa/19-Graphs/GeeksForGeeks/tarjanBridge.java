import java.util.ArrayList;

class Edge {
    int src;
    int dst;

    Edge(int s, int d) {
        src = s;
        dst = d;
    }
}

class Solution {
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }

        return tarjan(graph, V, c, d);
    }

    public boolean tarjan(ArrayList<Edge>[] graph, int V, int c, int d) {
        int[] dt = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        int time = 0;

        boolean edgeExists = false;
        for (Edge e : graph[c]) {
            if (e.dst == d) {
                edgeExists = true;
                break;
            }
        }

        if (!edgeExists) {
            return false;
        }

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(graph, i, -1, dt, low, vis, time, c, d)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(ArrayList<Edge>[] graph, int curr, int par, int[] dt, int[] low, boolean[] vis, int time,
            int c, int d) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (Edge e : graph[curr]) {
            int ngbr = e.dst;

            if (ngbr == par) {
                continue;
            } else if (!vis[ngbr]) {
                if (dfs(graph, ngbr, curr, dt, low, vis, time, c, d)) {
                    return true;
                }

                low[curr] = Math.min(low[curr], low[ngbr]);

                if ((curr == c && ngbr == d || curr == d && ngbr == c) && dt[curr] < low[ngbr]) {
                    return true;
                }
            } else {
                low[curr] = Math.min(low[curr], dt[ngbr]);
            }
        }

        return false;
    }
}