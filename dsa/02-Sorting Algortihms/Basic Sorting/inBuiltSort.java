import java.util.Arrays;
import java.util.Collections;

public class inBuiltSort {
    public static void main(String[] args) {
        Integer nums[] = { 5, 4, 1, 3, 2 };

        // average is O(nlogn) under all cases
        Arrays.sort(nums);
        printArr(nums);

        nums = new Integer[] { 5, 4, 1, 3, 2 }; // reassign
        Arrays.sort(nums, 1, 4);
        printArr(nums);

        nums = new Integer[] { 5, 4, 1, 3, 2 }; // reasssign
        Arrays.sort(nums, Collections.reverseOrder());
        printArr(nums);

        nums = new Integer[] { 5, 4, 1, 3, 2 }; // reassign
        Arrays.sort(nums, 1, 4, Collections.reverseOrder());
        printArr(nums);
    }

    private static void printArr(Integer[] nums) {
        System.out.print("\nsorted array: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
