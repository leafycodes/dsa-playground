//238. Product of Array Except Self

//Time Complexity: O(n) already very optimized, but we're not using as much space as we did using prefix or suffix arrays.
//O(n) space due to res[] array

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, product = 1, zeroCount = 0;
        // result array
        int[] result = new int[n];

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }

        if (zeroCount > 1) {
            // All elements will be 0 if there are more than one zeroes
            for (int i = 0; i < n; i++) {
                result[i] = 0;
            }

            // if there is one zero, we traverse to where that zero is and change everything
            // else to 0 due to that element
        } else if (zeroCount == 1) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    result[i] = product;
                } else {
                    result[i] = 0;
                }
            }

            // else if there are no zeroes, then we assign total product/num[i] to each one
        } else {
            for (int i = 0; i < n; i++) {
                result[i] = product / nums[i];
            }
        }

        return result;
    }
}