import java.util.ArrayList;

public class pairSumOne {
    // this is pretty much same as twoSum, except the fact that the arraylsit we are
    // provided is SORTED
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);

        int target = 9;
        System.out.println(pairSum(nums, target));
    }

    private static boolean pairSum(ArrayList<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            if (nums.get(left) + nums.get(right) == target) {
                return true;
            } else if (nums.get(left) + nums.get(right) < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
