// User function Template for Java

import java.util.Arrays;

class Solution {
    long findMinSum(int[] A, int[] B, int N) {
        Arrays.sort(A);
        Arrays.sort(B);

        long min = 0;
        for (int i = 0; i < B.length; i++) {
            min += Math.abs(A[i] - B[i]);
        }

        return min;
    }
}