class Solution {
    public int hammingWeight(int n) {
        // it is the number of set bits
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}