class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != ']') {
                st.push(ch);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '[') {
                    sb.insert(0, st.pop());
                }

                st.pop();
                String toRepeat = sb.toString();
                sb = new StringBuilder();

                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    sb.insert(0, st.pop());
                }

                int count = Integer.parseInt(sb.toString());
                toRepeat = toRepeat.repeat(count);

                for (int j = 0; j < toRepeat.length(); j++) {
                    st.push(toRepeat.charAt(j));
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.insert(0, st.pop());
        }

        return res.toString();
    }
}