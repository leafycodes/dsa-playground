public class isSorted {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 0 };
        System.out.println(isSortedArray(arr, 0));
    }

    private static boolean isSortedArray(int nums[], int i) {
        if (i == nums.length - 1) {
            return true;
        }

        if (nums[i] > nums[i + 1]) {
            return false;
        }

        return isSortedArray(nums, i + 1);
    }
}
