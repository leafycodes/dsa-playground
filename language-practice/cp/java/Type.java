import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows >= 1) {
            res.add(Arrays.asList(1));
        }

        if (numRows >= 2) {
            res.add(Arrays.asList(1, 1));
        }

        for (int i = 2; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    int curr = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                    temp.add(curr);
                }
            }

            res.add(temp);
        }

        return res;
    }
}