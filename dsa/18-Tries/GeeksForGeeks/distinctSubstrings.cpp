#include <bits/stdc++.h>
using namespace std;

struct Node {
    Node* child[26];
    int freq;
    // the frequency is not needed to be stored, but i used the code form a
    // previous question, thus just pasted it here

    Node() : freq(1) {
        for (int i = 0; i < 26; i++) {
            child[i] = nullptr;
        }
    }
};

class Trie {
   public:
    Node* root;

    Trie() {
        root = new Node();
        root->freq = -1;
    }

    ~Trie() { clear(root); }

    void clear(Node* node) {
        if (!node) return;
        for (int i = 0; i < 26; i++) {
            clear(node->child[i]);
        }
        delete node;
    }

    void insert(string word) {
        Node* curr = root;
        for (char ch : word) {
            int i = ch - 'a';
            if (!curr->child[i]) {
                curr->child[i] = new Node();
            } else {
                curr->child[i]->freq++;
            }
            curr = curr->child[i];
        }
    }

    int count_nodes(Node* root) {
        if (root == nullptr) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root->child[i] != nullptr) {
                count += count_nodes(root->child[i]);
            }
        }

        return count + 1;
    }
};

/*You are required to complete this method */
int countDistinctSubstring(string s) {
    Trie trie;
    for (int i = 0; i < s.length(); i++) {
        string suffix = s.substr(i);
        trie.insert(suffix);
    }

    return trie.count_nodes(trie.root);
}
