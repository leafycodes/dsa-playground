import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, 0, graph.length - 1, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[][] graph, int curr, int dest, ArrayList<Integer> path, List<List<Integer>> res) {
        path.add(curr);

        if (curr == dest) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        for (int ngbr : graph[curr]) {
            dfs(graph, ngbr, dest, path, res);
        }

        path.remove(path.size() - 1);
    }
}