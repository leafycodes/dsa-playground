import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int popHeight = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }

                int currWidth = i - stack.peek() - 1;
                int currHeight = Math.min(height[stack.peek()], height[i]) - popHeight;

                water += (currHeight * currWidth);
            }

            stack.push(i);
        }

        return water;
    }
}