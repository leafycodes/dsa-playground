// probably some issue with the inputs, since it gaives wrong answer and I have reviewed it and the code runs fine.

import java.util.*;
import java.lang.*;

class Main {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            sc.close();
            return;
        }

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        Node root = null;
        for (int i = 0; i < nums.length; i++) {
            root = insert(root, nums[i]);
        }

        System.out.print("Pre order :");
        preorder(root);
        System.out.println();

        System.out.print("In order  :");
        inorder(root);
        System.out.println();

        System.out.print("Post order:");
        postorder(root);
        System.out.println();
    }

    private static Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }

        return node;
    }

    private static void preorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(" " + node.val);
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(" " + node.val);
        inorder(node.right);
    }

    private static void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(" " + node.val);
    }
}