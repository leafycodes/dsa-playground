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

    public static void main(String[] args) {
        String words[] = { "the", "a", "there", "their", "any", "thee" };

        for (String word : words) {
            insert(word);
        }
        System.out.println(search("thee"));
        System.out.println(search("pizza"));
    }
}