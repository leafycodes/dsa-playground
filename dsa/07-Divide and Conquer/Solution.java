import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int nums[] = { 3, 6, 9, 8, 2, 5 };
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void quickSort(int[] nums, int si, int ei) {
        if (si >= ei)
            return;
        int pidx = partition(nums, si, ei);
        quickSort(nums, si, pidx - 1);
        quickSort(nums, pidx + 1, ei);
    }

    private static int partition(int[] nums, int si, int ei) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(ei - si + 1) + si; // Random pivot
        int pivot = nums[pivotIndex];

        // Move pivot to the end to simplify partitioning
        swap(nums, pivotIndex, ei);

        int i = si - 1; // Tracks the last position of elements < pivot

        for (int j = si; j < ei; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        // Place pivot in its correct position
        swap(nums, i + 1, ei);
        return i + 1; // Return pivot's final index
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}