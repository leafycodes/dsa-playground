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
    List<Integer> order = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traverseTree(root);
        return order;
    }

    private void traverseTree(TreeNode node) {
        if (node == null) {
            return;
        }

        traverseTree(node.left);
        order.add(node.val);
        traverseTree(node.right);
    }
}