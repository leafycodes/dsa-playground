class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> s = new Stack<>();
        Integer[] nextGreaterElement = new Integer[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            nextGreaterElement[i] = s.isEmpty() ? -1 : arr[s.peek()];
            s.push(i);
        }
        ArrayList<Integer> res = new ArrayList<>(Arrays.asList(nextGreaterElement));
        return res;
    }
}