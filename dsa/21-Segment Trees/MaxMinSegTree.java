public class MaxMinSegTree {
    static int tree[][];

    private static void init(int n) {
        tree = new int[4 * n][2];
    }

    // recursively build the segment tree -> O(n)
    private static void build(int nums[], int i, int left, int right) {
        if (left == right) {
            tree[i][0] = tree[i][1] = nums[left];
            return;
        }

        int mid = left + (right - left) / 2;
        build(nums, 2 * i + 1, left, mid);
        build(nums, 2 * i + 2, mid + 1, right);
        tree[i][0] = Math.min(tree[2 * i + 1][0], tree[2 * i + 2][0]);
        tree[i][1] = Math.max(tree[2 * i + 1][1], tree[2 * i + 2][1]);
    }

    // recursively find the sum of the given range -> O(logn)
    private static int[] getMaxMin(int nums[], int qi, int qj) {
        int n = nums.length;
        return getMaxMinHelper(0, 0, n - 1, qi, qj);
    }

    private static int[] getMaxMinHelper(int i, int si, int sj, int qi, int qj) {
        if (qj < si || qi > sj) { // no overlap
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        } else if (si >= qi && sj <= qj) { // complete overlap
            return new int[] { tree[i][0], tree[i][1] };
        } else { // partial overlap
            int mid = si + (sj - si) / 2;
            int left[] = getMaxMinHelper(2 * i + 1, si, mid, qi, qj);
            int right[] = getMaxMinHelper(2 * i + 2, mid + 1, sj, qi, qj);

            return new int[] { Math.min(left[0], right[0]), Math.max(left[1], right[1]) };
        }
    }

    // update the new numeber in the nums array and recursively update the segment
    // tree -> O(logn)
    private static void update(int nums[], int idx, int newVal) {
        if (idx < 0 || idx >= nums.length) {
            return;
        }

        nums[idx] = newVal;
        updateHelper(0, 0, nums.length - 1, idx, newVal);
    }

    private static void updateHelper(int i, int si, int sj, int idx, int newVal) {
        if (idx < si || idx > sj) { // index is not in the range, so no need to update
            return;
        }

        if (si == sj) {
            tree[i][0] = tree[i][1] = newVal;
            return;
        }

        int mid = si + (sj - si) / 2;
        updateHelper(2 * i + 1, si, mid, idx, newVal);
        updateHelper(2 * i + 2, mid + 1, sj, idx, newVal);

        tree[i][0] = Math.min(tree[2 * i + 1][0], tree[2 * i + 2][0]);
        tree[i][1] = Math.max(tree[2 * i + 1][1], tree[2 * i + 2][1]);
    }

    public static void main(String[] args) {
        int nums[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        init(nums.length);
        build(nums, 0, 0, nums.length - 1);

        // Test the segment tree
        int[] result1 = getMaxMin(nums, 2, 5);
        System.out.println("Range [2,5] - Min: " + result1[0] + ", Max: " + result1[1]);

        update(nums, 2, 20);

        int[] result2 = getMaxMin(nums, 2, 5);
        System.out.println("After update - Range [2,5] - Min: " + result2[0] + ", Max: " + result2[1]);
    }
}
