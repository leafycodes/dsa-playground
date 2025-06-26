import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            while (!st.isEmpty() && st.peek().compareTo(num.charAt(i)) > 0 && k > 0) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        res.reverse();
        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') {
            i++;
        }

        return i == res.length() ? "0" : res.substring(i).toString();

    }
}