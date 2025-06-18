import java.util.ArrayList;

public class monotonicArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(6);
        nums.add(5);
        nums.add(4);
        nums.add(4);

        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1))
                inc = false;
            if (nums.get(i) < nums.get(i + 1))
                dec = false;
        }
        System.out.println(inc || dec);
    }
}
