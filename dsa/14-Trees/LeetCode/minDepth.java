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
    private int min;

    private void dfs(TreeNode node, int height) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            min = Math.min(min, height);
            return;
        }

        dfs(node.left, height + 1);
        dfs(node.right, height + 1);
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        min = Integer.MAX_VALUE;
        dfs(root, 1);
        return min;
    }
}