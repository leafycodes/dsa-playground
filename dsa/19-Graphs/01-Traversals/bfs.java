import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        boolean vis[] = new boolean[adj.size()];
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                res.add(curr);
                vis[curr] = true;
                for (int i = 0; i < adj.get(curr).size(); i++) {
                    q.add(adj.get(curr).get(i));
                }
            }
        }

        return res;
    }
}