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
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max_helper(root);
        return max;
    }

    public int max_helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left_max = Math.max(0, max_helper(root.left));
        int right_max = Math.max(0, max_helper(root.right));

        max = Math.max(max, left_max + right_max + root.val);
        return Math.max(left_max, right_max) + root.val;
    }
}