import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int dest, cost;

    public Edge(int d, int c) {
        dest = d;
        cost = c;
    }

    @Override
    public int compareTo(Edge e2) {
        return this.cost - e2.cost;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[points.length];
        pq.add(new Edge(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for (int i = 0; i < points.length; i++) {
                    if (!vis[i]) {
                        int cost = Math.abs(points[curr.dest][0] - points[i][0]) +
                                Math.abs(points[curr.dest][1] - points[i][1]);
                        pq.add(new Edge(i, cost));
                    }
                }
            }
        }

        return finalCost;
    }
}