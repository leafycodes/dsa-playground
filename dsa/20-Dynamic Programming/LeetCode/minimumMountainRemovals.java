class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }

        int maxMountain = 0;
        for (int i = 1; i < n - 1; i++) {
            if (left[i] > 1 && right[i] > 1) {
                maxMountain = Math.max(maxMountain, left[i] + right[i] - 1);
            }
        }

        return n - maxMountain;
    }
}