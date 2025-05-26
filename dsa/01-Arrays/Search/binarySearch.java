import java.util.Arrays;

public class binarySearch {

    // binary search requires a sorted array tocorrectly compare the target and the
    // index

    // Time Complexity: O(log n)
    public static void main(String[] args) {
        int[] arr = { 2, 56, 7, 43, 23, 71, 17, 45, 21, 98 };
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int target = 56;

        // recursive way for bianry search
        int a = binSearchRec(arr, target);
        System.out.println(a != -1 ? target + " Found at index " + a : target + " NOT FOUND IN ARRAY");

        // iterative way for binary search
        int b = binSearchIter(arr, target);
        System.out.println(b != -1 ? target + " Found at index " + b : target + " NOT FOUND IN ARRAY");
    }

    // iterative binary search
    public static int binSearchIter(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    // recursive binary search
    public static int binSearchRec(int[] arr, int target) {
        return helper(arr, 0, arr.length - 1, target);
    }

    public static int helper(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return helper(arr, start, mid - 1, target);
        } else {
            return helper(arr, mid + 1, end, target);
        }
    }
}
