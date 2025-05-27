public class bubbleSort {
    public static void main(String[] args) {
        int nums[] = { 5, 4, 1, 3, 2 };

        // optimized bubble sort, best case is O(n) due to early exit if already sorted
        // average is O(n^2) under all other cases
        sort(nums);

        System.out.print("sorted array: ");
        printArr(nums);
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {

            // if no swaps were done then this value will remain false
            boolean swapDone = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    // if swaps are done in this pass then this updates swapDone to true, indicating
                    // there has been a swap
                    swapDone = true;
                    nums[j + 1] = nums[j + 1] + nums[j] - (nums[j] = nums[j + 1]);
                }
            }

            // if no swaps have been done, it means the array is already sorted by that
            // point and no need to go any further
            if (!swapDone) {
                break;
            }
        }
    }

    private static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
