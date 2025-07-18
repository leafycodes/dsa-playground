class Solution {
    public int findCenter(int[][] edges) {
        int u = edges[0][0];
        int v = edges[0][1];

        if (u == edges[1][0] || u == edges[1][1]) {
            return u;
        } else {
            return v;
        }
    }
}