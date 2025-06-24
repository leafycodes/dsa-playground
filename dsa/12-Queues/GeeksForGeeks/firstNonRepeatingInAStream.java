class Solution {
    public String FirstNonRepeating(String s) {
        // code here
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()) {
            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek() - 'a'] != 1) {
                q.remove();
            }

            if (q.isEmpty()) {
                res.append('#');
            } else {
                res.append(q.peek());
            }
        }

        return res.toString();
    }
}