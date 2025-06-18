import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            boolean isLonely = true, isUnique = true;

            if (i > 0 && (nums[i - 1] == nums[i] || nums[i - 1] + 1 == nums[i])) {
                isLonely = false;
            }

            if (i < nums.length - 1 && (nums[i + 1] == nums[i] || nums[i + 1] - 1 == nums[i])) {
                isLonely = false;
            }

            if ((i > 0 && nums[i - 1] == nums[i]) || (i < nums.length - 1 && nums[i + 1] == nums[i])) {
                isUnique = false;
            }

            if (isLonely && isUnique) {
                res.add(nums[i]);
            }
        }
        return res;
    }
}