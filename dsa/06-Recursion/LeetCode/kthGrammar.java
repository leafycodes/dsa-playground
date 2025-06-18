class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }

        int parentSymbol = kthGrammar(n - 1, (k + 1) / 2);
        if ((k & 1) == 1) {
            return parentSymbol;
        } else {
            return 1 - parentSymbol;
        }
    }
}