/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        helper(res, new ArrayList<>(), root);
        return res;
    }

    private void helper(List<String> res, List<Integer> temp, TreeNode root) {
        if (root == null) {
            return;
        }

        temp.add(root.val);

        if (root.left == null && root.right == null) {
            res.add(temp.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("->")));
        } else {
            if (root.left != null) {
                helper(res, temp, root.left);
            }

            if (root.right != null) {
                helper(res, temp, root.right);
            }
        }

        if (!temp.isEmpty()) {
            temp.remove(temp.size() - 1);
        }
    }
}