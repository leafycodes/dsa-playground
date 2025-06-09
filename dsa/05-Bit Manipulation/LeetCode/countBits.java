class Solution {
    // O(nlogn) as for each integer n, the max bits needed to store it is (logn + 1)
    public int[] countBits(int n) {
        int[] nums = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            nums[i] = countSetBits(i);
        }
        return nums;
    }

    private int countSetBits(int n) {
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

// O(n) as we find the bits absed on previously stored inputs
class Solution {
    public int[] countBits(int n) {
        int[] setBits = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            setBits[i] = setBits[i >> 1] + (i & 1);
        }

        return setBits;
    }
}