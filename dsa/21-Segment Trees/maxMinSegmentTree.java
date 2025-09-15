class Solution {
    // Returns a vector<int> of size 2 where:
    // [0] = minimum value in arr from index L to R (inclusive),
    // [1] = maximum value in arr from index L to R (inclusive).
    // Uses the prebuilt segTree where each node stores [min, max].
    // Segment tree indexing:
    // - For a node at idx, left child is at 2*idx + 1, right child at 2*idx + 2.
    public int[] getMinMax(int[] arr, int L, int R, int[][] segTree) {
        // code here
        return getMinMaxHelper(0, 0, arr.length - 1, L, R, arr, segTree);
    }

    private int[] getMinMaxHelper(int i, int si, int sj, int qi, int qj, int[] arr, int[][] segTree) {
        if (si > qj || sj < qi) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        } else if (si >= qi && sj <= qj) {
            return segTree[i];
        } else {
            int mid = si + (sj - si) / 2;
            int left[] = getMinMaxHelper(2 * i + 1, si, mid, qi, qj, arr, segTree);
            int right[] = getMinMaxHelper(2 * i + 2, mid + 1, sj, qi, qj, arr, segTree);

            return new int[] { Math.min(left[0], right[0]), Math.max(left[1], right[1]) };
        }
    }

    // Updates the value at arr[index] to 'value' and updates the segTree
    // accordingly.
    // Uses the prebuilt segTree where each node stores [min, max].
    // Segment tree indexing:
    // - For a node at idx, left child is at 2*idx + 1, right child at 2*idx + 2.
    public void updateValue(int[] arr, int index, int value, int[][] segTree) {
        // code here
        arr[index] = value;
        int n = arr.length;
        updateHelper(0, 0, n - 1, index, value, segTree);
    }

    private void updateHelper(int i, int si, int sj, int idx, int newVal, int[][] segTree) {
        if (idx < si || idx > sj) {
            return;
        }

        if (si == sj) {
            segTree[i][0] = newVal;
            segTree[i][1] = newVal;
            return;
        }

        if (si != sj) {
            int mid = si + (sj - si) / 2;
            updateHelper(2 * i + 1, si, mid, idx, newVal, segTree);
            updateHelper(2 * i + 2, mid + 1, sj, idx, newVal, segTree);

            segTree[i][0] = Math.min(segTree[2 * i + 1][0], segTree[2 * i + 2][0]);
            segTree[i][1] = Math.max(segTree[2 * i + 1][1], segTree[2 * i + 2][1]);
        }
    }
};