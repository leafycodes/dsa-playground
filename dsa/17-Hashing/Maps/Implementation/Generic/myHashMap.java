import java.util.LinkedList;
import java.util.ArrayList;

public class myHashMap {
    public static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int N; // array size -> no. of buckets;
        private int n; // no. of nodes
        private LinkedList<Node> buckets[]; // array of size N;

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.n = 0;
            this.N = 4;
            this.buckets = new LinkedList[N];

            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            return Math.abs(key.hashCode()) % N; // lie bw 0 to N-1
        }

        private int linkedListSearch(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int lli = 0;

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return lli;
                }
                lli++;
            }

            return -1;
        }

        public void put(K key, V value) {
            int bi = hashFunction(key); // we get the bucket indx from this function
            int lli = linkedListSearch(key, bi); // we get back the index of the ll on which we want to store the key

            if (lli != -1) {
                Node node = buckets[bi].get(lli);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double alpha = (double) n / N;
            if (alpha > 2.0) {
                // we need to rehash
                rehashing();
            }
        }

        @SuppressWarnings("unchecked")
        private void rehashing() {
            LinkedList<Node> prevBucket[] = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2;

            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // add from old to the new one
            for (int i = 0; i < prevBucket.length; i++) {
                LinkedList<Node> ll = prevBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(i);
                    put(node.key, node.value);
                }
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key); // we get the bucket indx from this function
            int lli = linkedListSearch(key, bi); // we get back the index of the ll on which we want to store the key

            if (lli != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key); // we get the bucket indx from this function
            int lli = linkedListSearch(key, bi); // we get back the index of the ll on which we want to store the key

            if (lli != -1) {
                Node node = buckets[bi].get(lli);
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key); // we get the bucket indx from this function
            int lli = linkedListSearch(key, bi); // we get back the index of the ll on which we want to store the key

            if (lli != -1) {
                Node node = buckets[bi].remove(lli);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public boolean isEmpty() {
            return n == 0; // n is no. of nodes
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }

            return keys;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> mp = new HashMap<>();

        mp.put("A", 100);
        mp.put("b", 2000);
        mp.put("A", 23232);
        mp.put("C", 990);

        ArrayList<String> keys = mp.keySet();
        for (String k : keys) {
            System.out.println(k + " : " + mp.get(k));
        }

        System.out.println(mp.get("A"));
        System.out.println(mp.remove("b"));
        System.out.println(mp.get("b"));
    }
}
