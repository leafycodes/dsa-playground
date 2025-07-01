//way 1 using the inorder sequence

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean isValidBST(TreeNode root) {
        Queue<Integer> list = new LinkedList<>();
        inorder(root, list);

        while (!list.isEmpty()) {
            int curr = list.remove();
            if (!list.isEmpty() && curr >= list.peek()) {
                return false;
            }
        }

        return true;
    }

    private void inorder(TreeNode root, Queue<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

// way 2 using inorder successros and predecessors
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null) {
            return true;
        }

        if (min != null && node.val <= min.val) {
            return false;
        } else if (max != null && node.val >= max.val) {
            return false;
        }

        return helper(node.left, min, node) && helper(node.right, node, max);
    }
}