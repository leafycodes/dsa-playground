public class occurenceInArray {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 2, 1, 34, 2, 5, 12, 4, 3 };
        int key = 4;
        System.out.println(firstOccurence(arr, key, 0));
        System.out.println(lastOccurence(arr, key, 0));
    }

    private static int firstOccurence(int[] nums, int key, int i) {
        if (i == nums.length) {
            return -1;
        }
        if (nums[i] == key) {
            return i;
        }
        return firstOccurence(nums, key, i + 1);
    }

    private static int lastOccurence(int[] nums, int key, int i) {
        if (i == nums.length) {
            return -1;
        }

        int isFound = lastOccurence(nums, key, i + 1);
        if (isFound == -1 && nums[i] == key) {
            return i;
        }

        return isFound;
    }
}
