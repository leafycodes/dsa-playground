public class countingSort {
    // it sorts in the time complexity of O(n + range), the bigger one
    // dominates.
    // it gives solution i nlinear time if you get a good case, the range (min to
    // max) is small

    public static void main(String[] args) {
        int nums[] = { 1, 4, 1, 3, 2, 4, 3, 7 };
        sort(nums);

        System.out.print("sorted array: ");
        printArr(nums);
    }

    public static void sort(int[] nums) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            largest = Math.max(largest, nums[i]);
        }

        int[] count = new int[largest + 1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[j++] = i;
                count[i]--;
            }
        }
    }

    private static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
