public class reverseArray {
    public static void main(String[] args) {
        int[] arr = { 2, 56, 7, 43, 23, 71, 17, 45, 21, 98 };
        System.out.print("original array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // remember that the array is passed by reference
        reverse(arr);

        System.out.print("\nreversed array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // two pointer approach to have linear time complexity and constant space.
    // Time Complexity: O(n)
    // Space Complexity: O(1) better than decalring a new array and making it O(n)
    // space
    public static void reverse(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            arr[low] = (arr[high] + arr[low]) - (arr[high] = arr[low]);
            low++;
            high--;
        }
    }
}
