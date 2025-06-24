class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = maxOfSubarrays(nums, k);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }

        return result;
    }
}