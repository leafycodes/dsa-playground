public class insertionSort {
    public static void main(String[] args) {
        int nums[] = { 5, 4, 1, 3, 2 };

        // average is O(n^2) under all cases
        sort(nums);

        System.out.print("sorted array: ");
        printArr(nums);
    }

    private static void sort(int nums[]) {
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i]; // this is the value, not the index
            int prev = i - 1; // this is an index

            // Store The value at i, not the index. the value is actingas the empty space
            // and will be overwritten by the previous element, so store nums[i] i ncurr,
            // not i

            while (prev >= 0 && nums[prev] > curr) {
                nums[prev + 1] = nums[prev--];
            }

            // now we can put the value here
            // know that the prev is one cell behidn the correct postion when it exits the
            // while loop
            nums[prev + 1] = curr;
        }
    }

    private static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
