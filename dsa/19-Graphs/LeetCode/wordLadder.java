import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }

        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }

        int lvl = 0, wordLength = beginWord.length();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        while (!q.isEmpty()) {
            ++lvl;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                char word[] = q.remove().toCharArray();
                for (int j = 0; j < wordLength; j++) {
                    char origChar = word[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        word[j] = ch;
                        String currWord = String.valueOf(word);
                        if (currWord.equals(endWord)) {
                            return lvl + 1;
                        }

                        if (!dict.contains(currWord)) {
                            continue;
                        }

                        dict.remove(currWord);
                        q.add(currWord);
                    }

                    word[j] = origChar;
                }
            }
        }
        return 0;
    }
}

// using a set is better for .contains TC (O(1)).
// a list.contains is O(n) -> will give TLE in this soln.