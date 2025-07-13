import java.util.HashMap;
import java.util.List;

class Solution {
    public class Trie {
        public class Node {
            Node child[] = new Node[26];
            boolean eow = false;
        }

        public Node root = new Node();

        public void insert(String word) {
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

        public boolean search(String key) {
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
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }
        HashMap<String, Boolean> memo = new HashMap<>();
        return wordBreakHelper(s, trie, memo);
    }

    public boolean wordBreakHelper(String key, Trie trie, HashMap<String, Boolean> memo) {
        if (key.length() == 0) {
            return true;
        }

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        for (int i = 1; i <= key.length(); i++) {
            if (trie.search(key.substring(0, i)) && wordBreakHelper(key.substring(i), trie, memo)) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}