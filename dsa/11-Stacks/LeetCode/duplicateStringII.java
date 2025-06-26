import java.util.Stack;

class Pair {
    int fq;
    char ch;

    Pair(char ch, int fq) {
        this.ch = ch;
        this.fq = fq;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && st.peek().ch == ch) {
                st.peek().fq++;

                if (st.peek().fq == k) {
                    st.pop();
                }
            } else {
                Pair p = new Pair(ch, 1);
                st.push(p);
            }
        }

        StringBuilder res = new StringBuilder();

        while (!st.isEmpty()) {
            int fq = st.peek().fq;
            char ch = st.peek().ch;
            st.pop();

            for (int i = 0; i < fq; i++) {
                res.append(ch);
            }
        }

        return res.reverse().toString();
    }
}
