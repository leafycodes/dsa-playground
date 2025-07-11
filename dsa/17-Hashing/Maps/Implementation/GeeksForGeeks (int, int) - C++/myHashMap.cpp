#include <functional>  // for std::hash
#include <list>
#include <vector>

class MyHashMap {
   private:
    struct Node {
        int key;
        int val;
        Node(int k, int v) : key(k), val(v) {}
    };

    int N;                     // Number of buckets
    int n;                     // Number of elements
    std::list<Node>* buckets;  // Array of linked lists

   public:
    /** Initialize your data structure here. */
    MyHashMap() {
        this->n = 0;
        this->N = 4;
        this->buckets = new std::list<Node>[N];

        // Initialize each bucket with an empty list
        for (int i = 0; i < N; i++) {
            buckets[i] = std::list<Node>();
        }
    }

    ~MyHashMap() { delete[] buckets; }

    /** Hash function */
    int hashFunction(int key) { return std::hash<int>{}(key) % N; }

    /** Search for a key in a bucket (returns position) */
    int linkedListSearch(int key, int bi) {
        auto& ll = buckets[bi];
        int pos = 0;
        for (auto it = ll.begin(); it != ll.end(); it++) {
            if (it->key == key) {
                return pos;
            }
            pos++;
        }
        return -1;
    }

    /** Insert or update a key-value pair */
    void put(int key, int val) {
        int bi = hashFunction(key);
        int lli = linkedListSearch(key, bi);

        if (lli != -1) {
            // Key exists: update value
            auto it = buckets[bi].begin();
            std::advance(it, lli);
            it->val = val;
        } else {
            // Key doesn't exist: insert new node
            buckets[bi].push_back(Node(key, val));
            n++;
        }

        // Rehash if load factor > 3.0
        if ((double)n / N > 3.0) {
            rehash();
        }
    }

    /** Rehash when load factor is too high */
    void rehash() {
        int old_N = N;
        N *= 2;  // Double the bucket size
        auto* oldBuckets = buckets;
        buckets = new std::list<Node>[N];

        // Initialize new buckets with empty lists
        for (int i = 0; i < N; i++) {
            buckets[i] = std::list<Node>();
        }

        // Reinsert all elements into the new buckets
        for (int i = 0; i < old_N; i++) {
            for (auto& node : oldBuckets[i]) {
                int new_bi = hashFunction(node.key);
                buckets[new_bi].push_back(node);
            }
        }

        delete[] oldBuckets;
    }

    /** Get the value for a key (returns -1 if not found) */
    int get(int key) {
        int bi = hashFunction(key);
        int lli = linkedListSearch(key, bi);

        if (lli != -1) {
            auto it = buckets[bi].begin();
            std::advance(it, lli);
            return it->val;
        } else {
            return -1;
        }
    }

    /** Remove a key if it exists */
    void remove(int key) {
        int bi = hashFunction(key);
        int lli = linkedListSearch(key, bi);

        if (lli != -1) {
            auto it = buckets[bi].begin();
            std::advance(it, lli);
            buckets[bi].erase(it);
            n--;
        }
    }
};