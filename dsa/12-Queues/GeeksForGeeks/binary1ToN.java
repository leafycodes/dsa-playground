class solve {

    // Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int n) {
        // Your code here
        Queue<String> q = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();

        q.add("1");
        while (n > 0) {
            String s1 = q.remove();

            list.add(s1);

            String s2 = new String(s1);
            q.add(s1 + "0");
            q.add(s2 + "1");

            n--;
        }

        return list;
    }
}
