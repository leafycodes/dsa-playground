import java.util.ArrayList;

class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    boolean vis[];

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        vis = new boolean[adj.size()];
        dfs(adj, 0);
        return res;
    }

    private void dfs(ArrayList<ArrayList<Integer>> graph, int curr) {
        res.add(curr);
        vis[curr] = true;

        for (int i = 0; i < graph.get(curr).size(); i++) {
            if (!vis[graph.get(curr).get(i)]) {
                dfs(graph, graph.get(curr).get(i));
            }
        }
    }
}