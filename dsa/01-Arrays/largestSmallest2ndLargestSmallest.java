public class largestSmallest2ndLargestSmallest {
    public static void main(String[] args) {
        int[] arr = { 2, 56, 7, 43, 23, 71, 17, 45, 21, 98 };

        linSearch(arr);
    }

    public static void linSearch(int[] arr) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, min = Integer.MAX_VALUE,
                secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            // Check for largest and second largest
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] <= max) {
                secondMax = arr[i];
            }

            // Check for smallest and second smallest
            if (arr[i] < min) {
                secondMin = min;
                min = arr[i];
            } else if (arr[i] < secondMin && arr[i] >= min) {
                secondMin = arr[i];
            }
        }
        // Print the results
        System.out.println("Largest: " + max + "\nSecond Largest: " + secondMax + "\nSmallest: " + min
                + "\nSecond Smallest: " + secondMin);
    }
}
