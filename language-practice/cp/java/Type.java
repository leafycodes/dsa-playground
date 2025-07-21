import java.util.Scanner;
import java.util.Stack;

class Pair {
    char ch;
    int fq;

    Pair(char ch, int fq) {
        this.ch = ch;
        this.fq = fq;
    }
}

class Solution {
    public static String makeFancyString(String s) {
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty() || st.peek().ch != s.charAt(i)) {
                st.push(new Pair(s.charAt(i), 1));
            } else if (st.peek().ch == s.charAt(i)) {
                st.peek().fq++;
                if (st.peek().fq >= 3) {
                    st.peek().fq = 2;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            Pair curr = st.pop();
            for (int i = 0; i < curr.fq; i++) {
                res.append(curr.ch);
            }
        }

        return res.reverse().toString();
    }
}

public class Type {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(Solution.makeFancyString(str));
        sc.close();
    }
}