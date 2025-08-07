import java.util.ArrayList;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : prerequisites) {
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
        }

        int in[] = new int[numCourses];
        for (ArrayList<Integer> vtx : adj) {
            for (Integer ngbr : vtx) {
                in[ngbr]++;
            }
        }

        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            for (; j < numCourses; j++) {
                if (in[j] == 0) {
                    break;
                }
            }

            if (j == numCourses) {
                return false;
            }

            in[j] = -1;
            for (int ngbr : adj.get(j)) {
                in[ngbr]--;
            }
        }

        return true;
    }
}