import java.util.ArrayList;

public class Main {
    static class Edge {
        int src, dst, wt;

        Edge(int src, int dst, int wt) {
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 5; // number of vertices
        ArrayList<Edge>[] graph = new ArrayList[v];
        // initialize to empty arraylists, they're currently null
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 2, 2));

        // neighbours of 2
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.dst + " ");
        }
    }
}