import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();
        helper(root, res, mp);
        return res;
    }

    private String helper(TreeNode node, List<TreeNode> res, HashMap<String, Integer> mp) {
        if (node == null) {
            return "#";
        }

        String key_of_map = node.val + "," + helper(node.left, res, mp) + "," + helper(node.right, res, mp);
        mp.put(key_of_map, mp.getOrDefault(key_of_map, 0) + 1);

        if (mp.get(key_of_map) == 2) {
            res.add(node);
        }

        return key_of_map;
    }
}