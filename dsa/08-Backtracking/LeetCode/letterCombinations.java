import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String num) {
        if (num == null || num.length() == 0) {
            return res;
        }
        combinations(num, 0, num.length(), new StringBuilder());
        return res;
    }

    final static String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    List<String> res = new ArrayList<>();

    private void combinations(String num, int i, int n, StringBuilder currStr) {
        if (i == n) {
            res.add(currStr.toString());
            return;
        }

        String currNum = letters[num.charAt(i) - '0'];

        for (int k = 0; k < currNum.length(); k++) {
            currStr.append(currNum.charAt(k));
            combinations(num, i + 1, n, currStr);
            currStr.deleteCharAt(currStr.length() - 1);
        }
    }
}