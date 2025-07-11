import java.util.LinkedList;

class MyHashMap {
    class Node {
        int key;
        int val;

        Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    private int N;
    private int n;
    private LinkedList<Node> buckets[];

    public MyHashMap() {
        this.n = 0;
        this.N = 4;
        this.buckets = new LinkedList[N];

        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int key) {
        return Math.abs(Integer.hashCode(key)) % N;
    }

    private int linkedListSearch(int key, int bi) {
        LinkedList<Node> ll = buckets[bi];
        for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i).key == key) {
                return i;
            }
        }

        return -1;
    }

    public void put(int key, int val) {
        int bi = hashFunction(key);
        int lli = linkedListSearch(key, bi);

        if (lli != -1) {
            Node node = buckets[bi].get(lli);
            node.val = val;
        } else {
            buckets[bi].add(new Node(key, val));
            n++;
        }

        // rehash if lambda more than constant
        double lambda = (double) n / N;
        if (lambda > 3.0) {
            rehash();
        }
    }

    private void rehash() {
        LinkedList<Node> oldBuckets[] = buckets;
        buckets = new LinkedList[N * 2];
        N = N * 2;

        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0; i < oldBuckets.length; i++) {
            LinkedList<Node> ll = oldBuckets[i];
            for (int j = 0; j < ll.size(); j++) {
                Node node = ll.get(j);
                put(node.key, node.val);
            }
        }
    }

    public int get(int key) {
        int bi = hashFunction(key);
        int lli = linkedListSearch(key, bi);

        if (lli != -1) {
            return buckets[bi].get(lli).val;
        } else {
            return -1;
        }
    }

    public void remove(int key) {
        int bi = hashFunction(key);
        int lli = linkedListSearch(key, bi);

        if (lli != -1) {
            buckets[bi].remove(lli);
            n--;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */