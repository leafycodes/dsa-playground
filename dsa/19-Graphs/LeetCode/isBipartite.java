import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].length; j++) {
                        int ngbr = graph[curr][j];
                        if (color[ngbr] == -1) {
                            int nextCol = color[curr] == 0 ? 1 : 0;
                            color[ngbr] = nextCol;
                            q.add(ngbr);
                        } else if (color[ngbr] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}