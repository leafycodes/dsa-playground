class Solution {
    // Function to reverse the queue.
    public Queue<Integer> reverseQueue(Queue<Integer> q) {
        // code here.
        Stack<Integer> s = new Stack();

        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        return q;
    }
}