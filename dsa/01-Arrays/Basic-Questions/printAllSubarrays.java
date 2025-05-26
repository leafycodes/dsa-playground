public class printAllSubarrays {
    public static void main(String[] args) {
        int[] arr = { 2, 56, 7, 43, 42 };
        int subarrays = 0;

        // Time Complexity: O(n^3)
        for (int i = 0; i < arr.length; i++) {
            // j starts from i to include the same element as i, as a single elemetn is also
            // a subarray
            for (int j = i; j < arr.length; j++) {
                System.out.print("-> ");

                // goes from i (start) to j (end)
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
                subarrays++;
            }
        }
        System.out.println("\ntotal subarrays: " + subarrays);
    }
}
