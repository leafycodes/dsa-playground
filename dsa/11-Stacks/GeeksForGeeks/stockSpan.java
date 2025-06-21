
class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
        ArrayList<Integer> span = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        span.add(1);
        s.push(0);

        for (int i = 1; i < arr.length; i++) {
            int currPrice = arr[i];

            while (!s.isEmpty() && currPrice >= arr[s.peek()]) {
                s.pop();
            }

            int spanValue = s.isEmpty() ? (i + 1) : (i - s.peek());
            span.add(spanValue);

            s.push(i);
        }

        return span;
    }
}