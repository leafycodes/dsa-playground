/*Complete the Given Function

Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=null;
        right=null;
    }
}*/

class Solution {
    public void toSumTree(Node root) {
        // add code here.
        transform(root);
    }

    private int transform(Node node) {
        if (node == null) {
            return 0;
        }

        int leftChild = transform(node.left);
        int rightChild = transform(node.right);

        int data = node.data;
        int left = node.left == null ? leftChild : leftChild + node.left.data;
        int right = node.right == null ? rightChild : rightChild + node.right.data;
        node.data = left + right;

        return data;
    }
}