import java.util.Stack;

public class duplicateParentheses {
    public static void main(String[] args) {
        String str = "(a+b)";

        System.out.println(isDuplicateParentheses(str));
    }

    private static boolean isDuplicateParentheses(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ')') {
                int count = 0;

                // the string is supposed to be balanced so it shouldn't be empty before a
                // closing tag appears
                while (s.peek() != '(') {
                    count++;
                    s.pop();
                }

                if (count == 0) {
                    return true;
                } else {
                    s.pop(); // this pops the opening pair
                }
            } else {
                s.push(ch);
            }
        }
        return false;
    }
}
