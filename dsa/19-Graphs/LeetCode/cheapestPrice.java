import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Edge {
    int src, dst, wt;

    public Edge(int s, int d, int w) {
        src = s;
        dst = d;
        wt = w;
    }
}

class Info {
    int vertex, cost, stops;

    public Info(int v, int c, int s) {
        vertex = v;
        cost = c;
        stops = s;
    }
}

class Solution {
    @SuppressWarnings("unchecked")
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int flight[] : flights) {
            int s = flight[0];
            int d = flight[1];
            int wt = flight[2];

            graph[s].add(new Edge(s, d, wt));
        }

        int dist[] = new int[n];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }

            for (Edge edge : graph[curr.vertex]) {
                int v = edge.dst;
                int wt = edge.wt;

                // curr.cost+wt , not dist[u]
                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
