/*
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Tree {
    // Recursive function to print right view of a binary tree.
    ArrayList<Integer> Kdistance(Node root, int k) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        if (k == 0) {
            res.add(root.data);
            return res;
        }

        helper(res, root, 0, k);
        return res;
    }

    void helper(ArrayList<Integer> res, Node root, int level, int k) {
        if (root == null || level > k) {
            return;
        }

        if (level == k) {
            res.add(root.data);
            return;
        }

        helper(res, root.left, level + 1, k);
        helper(res, root.right, level + 1, k);
    }
}