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
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;
        inOrder(node.right);
    }
}

// same (literally the same) for question 0530.
// I did not do this one [0783] by taking the two smallest ones or the two left
// most ones in a BST, rather finding minimum at every node. Tus, it works here
// as well