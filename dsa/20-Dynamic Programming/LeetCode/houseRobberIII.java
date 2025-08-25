import java.util.HashMap;
import java.util.TreeMap;

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
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return helper(root, memo);
    }

    private int helper(TreeNode node, HashMap<TreeNode, Integer> memo) {
        if (node == null) {
            return 0;
        }

        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        int leave = helper(node.left, memo) + helper(node.right, memo);
        int take = node.val;

        if (node.left != null) {
            take += helper(node.left.left, memo) + helper(node.left.right, memo);
        }

        if (node.right != null) {
            take += helper(node.right.left, memo) + helper(node.right.right, memo);
        }

        memo.put(node, Math.max(take, leave));
        return memo.get(node);
    }
}