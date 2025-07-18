import java.util.HashMap;

class Node {
    int key, val;
    Node next, prev;

    Node(int k, int v) {
        key = k;
        val = v;
        next = prev = null;
    }
}

class LRUCache {

    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void addFront(Node node) {
        Node next = head.next;

        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            addFront(node);

            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;

            deleteNode(node);
            addFront(node);
            return;
        }

        Node newNode = new Node(key, value);
        if (map.size() == capacity) {
            Node node = tail.prev;
            map.remove(node.key);
            deleteNode(node);
        }

        map.put(key, newNode);
        addFront(newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */