class Solution {
    public int tribonacci(int n) {
        int[] triArr = new int[38];
        triArr[0] = 0;
        triArr[1] = triArr[2] = 1;

        for (int i = 3; i <= n; i++) {
            triArr[i] = triArr[i - 1] + triArr[i - 2] + triArr[i - 3];
        }
        return triArr[n];
    }
}