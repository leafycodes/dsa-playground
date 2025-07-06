/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/
class Solution {
    // Function to find the least absolute difference between any node
    // value of the BST and the given integer.
    private static int min;

    static int minDiff(Node root, int K) {
        // Write your code here
        min = Integer.MAX_VALUE;
        helper(root, K);
        return min;
    }

    private static void helper(Node node, int k) {
        if (node == null) {
            return;
        }

        min = Math.min(min, Math.abs(node.data - k));

        if (k > node.data) {
            helper(node.right, k);
        } else if (k < node.data) {
            helper(node.left, k);
        } else {
            min = 0;
        }
    }
}