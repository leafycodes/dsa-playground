import java.util.ArrayList;

public class containerWithMostWater {
    public static int maxArea(ArrayList<Integer> height) {
        int maxWater = 0;
        int left = 0;
        int right = height.size() - 1;

        while (left < right) {
            maxWater = Math.max(maxWater, Math.min(height.get(left), height.get(right)) * (right - left));

            if (height.get(left) > height.get(right)) {
                right--;
            } else {
                left++;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(maxArea(height));
    }
}