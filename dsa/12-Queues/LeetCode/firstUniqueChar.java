class Solution {
    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        int first = -1;

        for (char ch : s.toCharArray()) {
            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek() - 'a'] != 1) {
                q.remove();
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                first = i;
                break;
            }
        }

        return first;
    }
}