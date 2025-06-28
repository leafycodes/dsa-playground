// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.LinkedList;
// import java.util.Queue;

// class Node {
//     int data;
//     Node left;
//     Node right;

//     Node(int data) {
//         this.data = data;
//         left = null;
//         right = null;
//     }
// }

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static class Pair {
        Node node;
        int hor_dist;

        Pair(Node node, int hor_dist) {
            this.node = node;
            this.hor_dist = hor_dist;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        // code here
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, Node> mp = new HashMap<>();

        q.add(new Pair(root, 0));
        q.add(null);

        int min = 0, max = 0;
        while (!q.isEmpty()) {
            Pair curr_node = q.remove();

            if (curr_node == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!mp.containsKey(curr_node.hor_dist)) {
                    mp.put(curr_node.hor_dist, curr_node.node);
                }

                if (curr_node.node.left != null) {
                    q.add(new Pair(curr_node.node.left, curr_node.hor_dist - 1));
                    min = Math.min(min, curr_node.hor_dist - 1);
                }

                if (curr_node.node.right != null) {
                    q.add(new Pair(curr_node.node.right, curr_node.hor_dist + 1));
                    max = Math.max(max, curr_node.hor_dist + 1);
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            res.add(mp.get(i).data);
        }

        return res;
    }
}