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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lDiam = diameterOfBinaryTree(root.left);
        int rDiam = diameterOfBinaryTree(root.right);
        int selfDiam = height(root.left) + height(root.right);

        return Math.max(Math.max(lDiam, rDiam), selfDiam);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }
}

// faster approach since it needs only one recursive function and not 2
class Solution {
    class Info {
        int dm;
        int ht;

        Info(int dm, int ht) {
            this.dm = dm;
            this.ht = ht;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Info res = helper(root);
        return res.dm;
    }

    private Info helper(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info l_info = helper(root.left);
        Info r_info = helper(root.right);

        int di = Math.max(Math.max(l_info.dm, r_info.dm), l_info.ht + r_info.ht);
        int ht = Math.max(l_info.ht, r_info.ht) + 1;

        return new Info(di, ht);
    }
}