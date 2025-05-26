// we use Kadane's algorithm for maximum subarray sumhere.
// Time Comp: O(n)
class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0, maxSum = Integer.MIN_VALUE, maxNegative = Integer.MIN_VALUE;
        boolean allNegative = true;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                allNegative = false;
            } else {
                maxNegative = Math.max(maxNegative, nums[i]);
            }

            currSum += nums[i];
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return allNegative ? maxNegative : maxSum;
    }
}