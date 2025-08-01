import java.util.Scanner;

public class Type {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(moves(nums));
    }

    public static long moves(int[] nums) {
        long move = 0;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < prev) {
                move += prev - nums[i];
            } else {
                prev = nums[i];
            }
        }

        return move;
    }
}