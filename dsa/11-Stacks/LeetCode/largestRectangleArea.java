import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nextSmallerLeftIndex = new int[n];
        int[] nextSmallerRightIndex = new int[n];

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nextSmallerLeftIndex[i] = -1;
            } else {
                nextSmallerLeftIndex[i] = s.peek();
            }

            s.push(i);
        }

        // this clears the stack to use
        while (!s.isEmpty()) {
            s.pop();
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nextSmallerRightIndex[i] = n;
            } else {
                nextSmallerRightIndex[i] = s.peek();
            }

            s.push(i);
        }

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int currArea = heights[i] * (nextSmallerRightIndex[i] - nextSmallerLeftIndex[i] - 1);
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }
}