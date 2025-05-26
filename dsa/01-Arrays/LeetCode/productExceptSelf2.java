//238. Product of Array Except Self

//Time Complexity: O(n) already very optimized, but we're using too much sapce by creating two more arrays prefix[] and suffix[] of the same length

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // the size will be minimum of 2, so base case not needed

        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        for (int i = 1; i < n - 1; i++) {
            nums[i] = prefix[i - 1] * suffix[i + 1];
        }

        nums[0] = suffix[1];
        nums[n - 1] = prefix[n - 2];

        return nums;
    }
}