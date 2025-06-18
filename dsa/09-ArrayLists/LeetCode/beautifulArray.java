import java.util.ArrayList;

class Solution {
    ArrayList<Integer> res = new ArrayList<>();

    public int[] beautifulArray(int n) {
        buildBeautifulArray(1, 1, n);

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private void buildBeautifulArray(int current, int step, int n) {
        if (current + step > n) {
            res.add(current);
            return;
        }

        buildBeautifulArray(current, step * 2, n);
        buildBeautifulArray(current + step, step * 2, n);
    }
}