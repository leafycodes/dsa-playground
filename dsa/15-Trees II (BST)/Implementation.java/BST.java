public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    private static Node insert(Node node, int val) {
        if (node == null) {
            node = new Node(val);
            return node;
        }

        if (node.data > val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }

        return node;
    }

    private static void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
    }
}