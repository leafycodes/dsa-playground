// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca = lowestCommonAncestor(root, a, b);
        int distA = lcaDist(lca, a);
        int distB = lcaDist(lca, b);

        return distA + distB;
    }

    Node lowestCommonAncestor(Node node, int a, int b) {
        if (node == null || node.data == a || node.data == b) {
            return node;
        }

        Node leftLCA = lowestCommonAncestor(node.left, a, b);
        Node rightLCA = lowestCommonAncestor(node.right, a, b);

        if (leftLCA == null) {
            return rightLCA;
        } else if (rightLCA == null) {
            return leftLCA;
        }

        return node;
    }

    int lcaDist(Node node, int k) {
        if (node == null) {
            return -1;
        }

        if (node.data == k) {
            return 0;
        }

        int leftDist = lcaDist(node.left, k);
        int rightDist = lcaDist(node.right, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }
}