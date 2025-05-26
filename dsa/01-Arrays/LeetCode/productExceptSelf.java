//238. Product of Array Except Self

//Tiem Complexity: O(n^2)
//This code will not be accepted due to TLE

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // result array
        int res[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    product *= nums[j];
                }
            }
            res[i] = product;
        }

        return res;
    }
}