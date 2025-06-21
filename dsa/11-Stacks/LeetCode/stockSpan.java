class StockSpanner {
    Stack<int[]> s = new Stack<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int span = 1;
        while (!s.isEmpty() && s.peek()[0] <= price) {
            span += s.pop()[1];
        }

        s.push(new int[] { price, span });
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */