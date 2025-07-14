public class TrieMain {
    static class Node {
        Node child[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int ch : word.toCharArray()) {
            int i = ch - 'a';
            if (curr.child[i] == null) {
                curr.child[i] = new Node();
            }
            curr = curr.child[i];
        }

        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for (char ch : key.toCharArray()) {
            int i = ch - 'a';
            if (curr.child[i] == null) {
                return false;
            }
            curr = curr.child[i];
        }

        return curr.eow;
    }

    public static boolean isEmpty(Node node) {
        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                return false;
            }
        }

        return true;
    }

    public static boolean remove(Node node, String word, int depth) {
        if (node == null) {
            return false;
        }

        // base case: reached the end of the word
        if (depth == word.length()) {
            if (!node.eow) {
                return false; // word doesn't exist in trie
            }
            node.eow = false; // mark as non-end of word
            return isEmpty(node);// if the node has no children, it can be deleted
        }

        // recursive case: process the next character
        int index = word.charAt(depth) - 'a';
        if (remove(node.child[index], word, depth + 1)) {
            // child node can be deleted
            node.child[index] = null;

            // if current node is not end of word and has no other children, it can be
            // deleted
            return !node.eow && isEmpty(node);
        }
        return false;
    }

    public static boolean startsWith(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (curr.child[i] == null) {
                return false;
            }

            curr = curr.child[i];
        }

        return true;
    }

    public static void main(String[] args) {
        String words[] = { "the", "a", "there", "their", "any", "thee" };

        for (String word : words) {
            insert(word);
        }
        System.out.println(search("thee"));
        System.out.println(search("pizza"));
        // the insertion and search are generally used, remove is not much used, but the
        // implementation is provided
        remove(root, "thee", 0);
        System.out.println(search("thee"));
        System.out.println(startsWith("th"));
        System.out.println(startsWith("apple"));
    }
}