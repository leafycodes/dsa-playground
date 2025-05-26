public class linearSearch {
    public static void main(String[] args) {
        int[] arr = { 2, 56, 7, 43, 23, 71, 17, 45, 21, 98 };
        int target = 17;

        int index = linSearch(arr, target);
        System.out.println(index != -1 ? target + " found at " + index : "TARGET NOT FOUND");
    }

    public static int linSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
