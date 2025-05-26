//we use brute force here. Time Comp: O(n^3)
//Not accepeted due to TLE
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        // Time Complexity: O(n^3)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += nums[k];
                }
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }
}