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
    class Info {
        boolean isBST;
        int sum;
        int min;
        int max;

        Info(boolean isBST, int sum, int min, int max) {
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private Info helper(TreeNode node) {
        if (node == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = helper(node.left);
        Info rightInfo = helper(node.right);

        int sum = leftInfo.sum + rightInfo.sum + node.val;
        int min = Math.min(Math.min(leftInfo.min, rightInfo.min), node.val);
        int max = Math.max(Math.max(leftInfo.max, rightInfo.max), node.val);

        if (node.val <= leftInfo.max || node.val >= rightInfo.min) {
            return new Info(false, sum, min, max);
        }

        if (leftInfo.isBST && rightInfo.isBST) {
            maxSum = Math.max(maxSum, sum);
            return new Info(true, sum, min, max);
        }

        return new Info(false, sum, min, max);
    }
}