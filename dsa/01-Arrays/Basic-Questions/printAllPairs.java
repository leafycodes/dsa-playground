public class printAllPairs {
    public static void main(String[] args) {
        int[] arr = { 2, 56, 7, 43, 42 };
        int pairs = 0;

        // Time Complexity: O(n^2)
        for (int i = 0; i < arr.length; i++) {
            // j starts from i+1 to not include the same element as i
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + ", " + arr[j] + ") ");
                ++pairs;
            }
            System.out.println();
        }
        System.out.println("total pairs: " + pairs);
    }
}
