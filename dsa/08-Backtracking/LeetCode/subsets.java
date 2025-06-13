import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, new ArrayList<>(), 0);
        return res;
    }

    private void helper(int[] nums, List<Integer> ans, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        helper(nums, ans, i + 1); // without adding
        ans.add(nums[i]); // we give the decsion to add it
        helper(nums, ans, i + 1);
        ans.remove(ans.size() - 1); // since ans is one reference, we need to remove the element before returning.
                                    // eg. [1,2] -> [1], [1,2] as 2 will be included with 1, which was not removed
    }
}