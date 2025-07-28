import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int in[] = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            // u,v -> take v before , i.e. v -> u
            graph.get(v).add(u);
            in[u]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }

        int k = 0;
        int res[] = new int[numCourses];
        while (!q.isEmpty()) {
            int curr = q.remove();
            res[k] = curr;
            k++;

            for (int ngbr : graph.get(curr)) {
                in[ngbr]--;
                if (in[ngbr] == 0) {
                    q.add(ngbr);
                }
            }
        }

        return k == numCourses ? res : new int[0];
    }
}