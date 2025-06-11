class Solution {

    List<String> res = new ArrayList<>();

    public List<String> validStrings(int n) {
        StringMaker(n, 1, "");
        return res;
    }

    private void StringMaker(int n, int lastPlace,
            String str) {
        if (n == 0) {
            res.add(str);
            return;
        }

        StringMaker(n - 1, 1, str + "1");
        if (lastPlace == 1) {
            StringMaker(n - 1, 0, str + "0");
        }
    }
}