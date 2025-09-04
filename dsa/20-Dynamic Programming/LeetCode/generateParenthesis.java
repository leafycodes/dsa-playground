import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char str[] = new char[2 * n];
        helper(str, 0, n, 0, 0, res);
        return res;
    }

    private void helper(char str[], int pos, int n, int open, int close, List<String> res) {
        if (close == n) {
            res.add(new String(str));
            return;
        }

        if (open > close) {
            str[pos] = ')';
            helper(str, pos + 1, n, open, close + 1, res);
        }

        if (open < n) {
            str[pos] = '(';
            helper(str, pos + 1, n, open + 1, close, res);
        }
    }
}