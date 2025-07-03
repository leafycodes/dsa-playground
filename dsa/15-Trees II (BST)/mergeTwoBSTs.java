// well i did find merging two binary search trees into one balanced tree. but
// the GfG one was only adking for a merged arraylist and not the tree, and the
// leetcode one would have been too hard to elaborate here, and i was unable to
// find similar question elsewhere, so i am doing it manually here. (there might
// exist a website where this is asked and i didn't know of it).

import java.util.ArrayList;

public class mergeTwoBSTs {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        /*
         * tree1
         *
         * .... 2
         * ... / \
         * ...1.. 4
         *
         */

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        /*
         * tree2
         *
         * .... 9
         * ... / \
         * .. 3.. 12
         */

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        /*
         * merged BST
         *
         * ...... 3
         * .... /...\
         * ....1..... 9
         * .... \... /.\
         * ......2..4...12
         */

        Node root = merge(root1, root2);
        preorder(root);
    }

    private static Node merge(Node root1, Node root2) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        getInorder(root1, list1);
        getInorder(root2, list2);

        int i = 0, j = 0;
        ArrayList<Integer> mergedList = new ArrayList<>();
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return createBST(mergedList, 0, mergedList.size() - 1);
    }

    private static void getInorder(Node node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }

        getInorder(node.left, list);
        list.add(node.val);
        getInorder(node.right, list);
    }

    private static Node createBST(ArrayList<Integer> nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        Node newNode = new Node(nums.get(mid));
        newNode.left = createBST(nums, left, mid - 1);
        newNode.right = createBST(nums, mid + 1, right);

        return newNode;
    }

    private static void preorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }
}