public class selectionSort {
    public static void main(String[] args) {
        int nums[] = { 5, 4, 1, 3, 2 };

        // average is O(n^2) under all cases, but it does n swaps only
        // selection sort makes lesser numebr of swaps than bubble sort
        sort(nums);

        System.out.print("sorted array: ");
        printArr(nums);
    }

    private static void sort(int nums[]) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minPointer = i;
            // select minimun from the rest of the array and swap after the loop
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minPointer] > nums[j]) {
                    minPointer = j;
                }
            }
            nums[minPointer] = nums[minPointer] + nums[i] - (nums[i] = nums[minPointer]);
        }
    }

    private static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
