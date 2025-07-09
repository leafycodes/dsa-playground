import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int idx;
    int soldiers;

    Pair(int i, int sol) {
        soldiers = sol;
        idx = i;
    }

    @Override
    public int compareTo(Pair p2) {
        if (p2.soldiers == this.soldiers) {
            return this.idx - p2.idx;
        } else {
            return this.soldiers - p2.soldiers;
        }
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                count += 1;
            }
            pq.add(new Pair(i, count));
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove().idx;
        }
        return res;
    }
}