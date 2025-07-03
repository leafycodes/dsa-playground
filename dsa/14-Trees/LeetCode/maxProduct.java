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
    private long maxProduct = 0;
    private long mod = 1000000007;
    private long totalSum = 0;

    public int maxProduct(TreeNode root) {
        totalSum = sumOfTree(root);
        findMaxProduct(root);

        return (int) (maxProduct % mod);
    }

    private long findMaxProduct(TreeNode node) {
        if (node == null)
            return 0;

        long currentSum = node.val + findMaxProduct(node.left) + findMaxProduct(node.right);
        long product = currentSum * (totalSum - currentSum);

        maxProduct = Math.max(maxProduct, product);
        return currentSum;
    }

    private int sumOfTree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return node.val + sumOfTree(node.left) + sumOfTree(node.right);
    }
}