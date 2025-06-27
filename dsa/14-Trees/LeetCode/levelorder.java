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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> temp = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode currNode = q.remove();

            if (currNode == null) {
                if (!temp.isEmpty()) {
                    res.add(new ArrayList<>(temp));
                    temp.clear();
                }

                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                temp.add(currNode.val);
                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }

        return res;
    }
}