import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Trie {
    class Node {
        List<String> data;
        Node child[];
        boolean eow;

        public Node() {
            data = new ArrayList<>();
            child = new Node[26];
            eow = false;
        }
    }

    public Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String str) {
        Node curr = root;
        char[] word = str.toCharArray();
        Arrays.sort(word);
        for (char ch : word) {
            Node child = curr.child[ch - 'a'];
            if (child == null) {
                curr.child[ch - 'a'] = new Node();
            }
            curr = curr.child[ch - 'a'];
        }

        curr.eow = true;
        curr.data.add(str);
    }
}

class Solution {
    List<List<String>> res;

    public void dfsHelper(Trie.Node node) {
        if (node.eow) {
            res.add(node.data);
        }

        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                dfsHelper(node.child[i]);
            }
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Trie trie = new Trie();
        res = new ArrayList<>();

        for (String word : strs) {
            trie.insert(word);
        }

        dfsHelper(trie.root);
        return res;
    }
}