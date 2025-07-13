/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

import java.util.ArrayList;
import java.util.TreeMap;

class Solution {
    public ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        TreeMap<Integer, int[]> map = new TreeMap<>();
        // hd, height, data
        helper(root, 0, 0, map);
        for (int val[] : map.values()) {
            res.add(val[0]);
        }

        return res;
    }

    private void helper(Node node, int curr, int hd, TreeMap<Integer, int[]> map) {
        if (node == null) {
            return;
        }

        if (!map.containsKey(hd)) {
            map.put(hd, new int[] { node.data, curr });
        } else {
            int[] p = map.get(hd);
            if (p[1] <= curr) {
                p[1] = curr;
                p[0] = node.data;
            }
            map.put(hd, p);
        }

        helper(node.left, curr + 1, hd - 1, map);
        helper(node.right, curr + 1, hd + 1, map);
    }
}