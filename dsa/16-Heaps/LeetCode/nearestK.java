import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    class Point implements Comparable<Point> {
        int x;
        int y;
        int dist;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            dist = x * x + y * y;
        }

        @Override
        public int compareTo(Point p2) {
            return this.dist - p2.dist;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int[] point : points) {
            pq.add(new Point(point[0], point[1]));
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Point curr = pq.remove();
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(curr.x);
            pair.add(curr.y);
            res.add(pair);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i][0] = res.get(i).get(0);
            result[i][1] = res.get(i).get(1);
        }
        return result;
    }
}