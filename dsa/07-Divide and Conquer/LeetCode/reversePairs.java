class Solution {
    public int reversePairs(int[] nums) {
        return countPairs(nums, 0, nums.length - 1); //
        // basically the merge sort
    }

    private int countPairs(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int res = 0;
        res += countPairs(nums, left, mid);
        res += countPairs(nums, mid + 1, right);
        res += countMergedPairs(nums, left, mid, right);
        merge(nums, left, mid, right);

        return res;
    }

    private int countMergedPairs(int nums[], int left,
                                 int mid,
                                 int right) {
        int count = 0;
        int i = left, j = mid + 1;
        for (; i <= mid; i++) {
            while (j <= right && nums[i] > (2L * nums[j])) {
                j++;
            }
            count += (j - (mid + 1));
        }
        return count;
    }

    private void merge(int[] nums, int left, int mid,
                       int right) {
        int temp[] = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (k = 0, i = left; k < temp.length; k++, i++) {
            nums[i] = temp[k];
        }
    }
}