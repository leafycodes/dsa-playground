class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : arr) {
            pq.add(i);
        }

        int res = 0;
        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            res += sum;
            pq.add(sum);
        }

        return res;
    }
}