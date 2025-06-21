class Solution {
    public String reverse(String S) {
        // code here
        int i = 0;
        Stack<Character> st = new Stack<>();

        while (i < S.length()) {
            st.push(S.charAt(i++));
        }

        StringBuilder res = new StringBuilder("");
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.toString();

    }
}