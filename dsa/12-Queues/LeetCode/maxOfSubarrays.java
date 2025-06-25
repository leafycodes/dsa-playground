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

// sliding window - leetcode

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
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        res.add(arr[dq.peekFirst()]);

        for (int i = k; i < arr.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            res.add(arr[dq.peekFirst()]);
        }

        return res;
    }
}