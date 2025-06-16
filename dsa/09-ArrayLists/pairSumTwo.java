import java.util.ArrayList;

public class pairSumTwo {
    // this is pretty much same as twoSum, except the fact that the arraylsit we are
    // provided is SORTED & ROTATED
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(11);
        nums.add(15);
        nums.add(6);
        nums.add(8);
        nums.add(9);
        nums.add(10);

        int target = 16;
        System.out.println(pairSum(nums, target));
    }

    private static boolean pairSum(ArrayList<Integer> nums, int target) {

        int pivot = -1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                pivot = i;
                break;
            }
        }

        int left = pivot + 1;
        int right = pivot;

        while (left != right) {
            if (nums.get(left) + nums.get(right) == target) {
                return true;
            } else if (nums.get(left) + nums.get(right) < target) {
                left = (left + 1) % nums.size();
            } else {
                right = (nums.size() + right - 1) % nums.size();
            }
        }
        return false;
    }
}
