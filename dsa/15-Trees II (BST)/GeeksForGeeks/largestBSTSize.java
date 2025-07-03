// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }
class Solution {

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    } // Return the size of the largest sub-tree which is also a BST

    static int largestBst(Node root) {
        // Write your code here
        maxSize = 0;
        helper(root);
        return maxSize;
    }

    static int maxSize = 0;

    private static Info helper(Node node) {
        if (node == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = helper(node.left);
        Info right = helper(node.right);

        int size = left.size + right.size + 1;
        int min = Math.min(Math.min(left.min, right.min), node.data);
        int max = Math.max(Math.max(left.max, right.max), node.data);

        if (node.data <= left.max || node.data >= right.min) {
            return new Info(false, size, min, max);
        }

        if (left.isBST && right.isBST) {
            maxSize = Math.max(maxSize, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }
}