class Solution {
    // Time comp: O(logn)
    public int search(int[] nums, int target) {
        // first we find where the shift begin
        int shift = findShift(nums);

        // then we try shift the mid value by shift % MOD and do the same binary search
        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;

            int realMid = (mid + shift) % nums.length;

            if (nums[realMid] == target) {
                return realMid;
            } else if (nums[realMid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private static int findShift(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;

        while (left < right) {
            mid = (left + right) / 2;
            // this should not be the case for a sorted array
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}