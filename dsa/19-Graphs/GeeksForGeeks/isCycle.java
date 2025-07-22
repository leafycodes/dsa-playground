import java.util.ArrayList;

class Edge {
    int src, dst;

    Edge(int s, int d) {
        src = s;
        dst = d;
    }
}

class Solution {
    @SuppressWarnings("unchecked")
    public boolean isCycle(int V, int[][] edges) {
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

        boolean vis[] = new boolean[V];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleHelper(graph, vis, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isCycleHelper(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dst]) {
                if (isCycleHelper(graph, vis, e.dst, curr)) {
                    return true;
                }
            } else if (vis[e.dst] && e.dst != par) {
                return true;
            }
        }

        return false;
    }
}