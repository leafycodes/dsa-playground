/*
Structure of Node class is:

class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/

class Solution {
    public int kthAncestor(Node root, int k, int node) {
        List<Integer> path = new ArrayList<>();
        if (!findPath(root, node, path)) {
            return -1;
        }
        int index = path.size() - 1 - k;
        return (index >= 0) ? path.get(index) : -1;
    }

    private boolean findPath(Node root, int node, List<Integer> path) {
        if (root == null) {
            return false;
        }

        path.add(root.data);

        if (root.data == node) {
            return true;
        }

        if (findPath(root.left, node, path) || findPath(root.right, node, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}