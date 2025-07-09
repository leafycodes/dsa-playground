import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            sum += num;
            pq.add((double) num);
        }

        double target = sum / 2;
        int operations = 0;
        double reduced = 0;

        while (reduced < target) {
            double curr = pq.poll();
            double half = curr / 2;
            reduced += half;
            pq.add(half);
            operations++;
        }

        return operations;
    }
}