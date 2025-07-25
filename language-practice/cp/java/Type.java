import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        boolean allNeg = true;
        int maxNeg = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num >= 0) {
                allNeg = false;
            }
            maxNeg = Math.max(maxNeg, num);
        }

        if (allNeg) {
            return maxNeg;
        }

        Set<Integer> set = new HashSet<>();
        int max = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);
                    max += nums[j];
                }
            }
        }

        return max;
    }
}

public class Type {
    public static void main(String[] args) {
        int nums[] = { -95, 23, 23, -94 };
        Solution s = new Solution();
        int res = s.maxSum(nums);
        System.out.println(res);
    }
}