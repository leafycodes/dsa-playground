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
    private int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs_helper(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode dfs_helper(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[idx++]);

        int mid = lin_search(inorder, node.val);
        node.left = dfs_helper(preorder, inorder, left, mid - 1);
        node.right = dfs_helper(preorder, inorder, mid + 1, right);
        return node;
    }

    private int lin_search(int[] inorder, int key) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }
}