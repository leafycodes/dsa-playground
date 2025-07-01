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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            // leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // two childs (inorder successor)
            TreeNode insc = inorderSuccessor(root.right); // leftmost node in right subtree
            root.val = insc.val;
            root.right = deleteNode(root.right, insc.val);
        }

        return root;
    }

    private TreeNode inorderSuccessor(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}