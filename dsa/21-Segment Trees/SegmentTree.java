public class SegmentTree {
    static int tree[];

    private static void init(int n) {
        tree = new int[4 * n];
    }

    // recursively build the segment tree
    private static int build(int nums[], int i, int left, int right) {
        if (left == right) {
            tree[i] = nums[left];
            return tree[i];
        }

        int mid = left + (right - left) / 2;
        build(nums, 2 * i + 1, left, mid);
        build(nums, 2 * i + 2, mid + 1, right);
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
        return tree[i];
    }

    private static int getSum(int nums[], int qi, int qj) {
        int n = nums.length;
        return getSumHelper(0, 0, n - 1, qi, qj);
    }

    private static int getSumHelper(int i, int si, int sj, int qi, int qj) {
        if (qj <= si || qi >= sj) { // no overlap
            return 0;
        } else if (si >= qi && sj <= qj) { // complete overlap
            return tree[i];
        } else { // partial overlap
            int mid = si + (sj - si) / 2;
            int left = getSumHelper(2 * i + 1, si, mid, qi, qj);
            int right = getSumHelper(2 * i + 2, mid + 1, sj, qi, qj);
            return left + right;
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        init(nums.length);
        build(nums, 0, 0, nums.length - 1);

        for (int i : tree) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(getSum(nums, 2, 5));
    }
}
