import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

import buildWithPreorder.Node;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();

        getPath(root, p, pathP);
        getPath(root, q, pathQ);

        int i = 0;
        for (; i < pathP.size() && i < pathQ.size(); i++) {
            if (pathP.get(i) != pathQ.get(i)) {
                break;
            }
        }

        return pathP.get(i - 1);
    }

    private static boolean getPath(TreeNode root, TreeNode k, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root == k) {
            return true;
        }

        boolean foundLeft = getPath(root.left, k, path);
        boolean foundRight = getPath(root.right, k, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}