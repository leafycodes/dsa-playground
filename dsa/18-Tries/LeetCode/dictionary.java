class Solution {
    private static class Node {
        char data;
        String word;
        boolean eow;
        Node child[];

        public Node(char data) {
            this.data = data;
            this.word = null;
            this.eow = false;
            this.child = new Node[26];
        }
    }

    private Node root = new Node('#');
    private String res = "";

    private void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (curr.child[i] == null) {
                curr.child[i] = new Node(ch);
            }

            curr = curr.child[i];
        }

        curr.eow = true;
        curr.word = word;
    }

    private void dfsHelper(Node node) {
        if (node == null) {
            return;
        }

        if (node.word != null) {
            if (node.word.length() > res.length()) {
                res = node.word;
            } else if (node.word.length() == res.length() && node.word.compareTo(res) < 0) {
                res = node.word;
            }
        }

        for (Node child : node.child) {
            if (child != null && child.word != null) {
                dfsHelper(child);
            }
        }
    }

    public String longestWord(String[] words) {
        for (String word : words) {
            insert(word);
        }

        dfsHelper(root);
        return res;
    }
}