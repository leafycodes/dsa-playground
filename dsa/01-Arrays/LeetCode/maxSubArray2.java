//we use prefix aray method. Time Comp: O(n^2)
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        // Time Complexity: O(n^2)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }
}