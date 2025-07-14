#include <bits/stdc++.h>
using namespace std;

struct Node {
    Node* child[26];
    bool eow;
    int freq;

    Node() {
        for (int i = 0; i < 26; i++) {
            child[i] = nullptr;
        }
        eow = false;
        freq = 1;
    }
};

class Trie {
   public:
    Node* root;

    Trie() {
        root = new Node();
        root->freq = -1;
    }

    void insert(string word) {
        Node* curr = root;
        for (char ch : word) {
            int i = ch - 'a';
            if (curr->child[i] == nullptr) {
                curr->child[i] = new Node();
            } else {
                curr->child[i]->freq++;
            }
            curr = curr->child[i];
        }
        curr->eow = true;
    }
};

class Solution {
   public:
    void find_prefixes_helper(Node* root, string& word, string current,
                              int index, vector<string>& res) {
        if (root == nullptr) {
            return;
        }

        if (root->freq == 1) {
            res.push_back(current);
            return;
        }

        if (index < word.length()) {
            int i = word[index] - 'a';
            if (root->child[i] != nullptr) {
                find_prefixes_helper(root->child[i], word,
                                     current + word[index], index + 1, res);
            }
        }
    }

    vector<string> findPrefixes(string arr[], int n) {
        Trie trie;
        for (int i = 0; i < n; i++) {
            trie.insert(arr[i]);
        }

        vector<string> res;
        for (int i = 0; i < n; i++) {
            find_prefixes_helper(trie.root, arr[i], "", 0, res);
        }
        return res;
    }
};

// the above code is just calling find prefixes for each word individually since
// we need the correct order as well. eg -> zebra dog duck dove -> z dog du dov
// but we gave -> dog dov du z, this we called this separately for different
// ones.

// since then, it passes 1003/1005 cases. 2 cases MLE
// below is a more memory efficient code which passes all cases:

#include <bits/stdc++.h>
using namespace std;

struct Node {
    Node* child[26];
    int freq;

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
};

class Solution {
   public:
    void find_prefixes_helper(Node* node, string& word, string& prefix, int pos,
                              vector<string>& res) {
        if (node->freq == 1) {
            res.push_back(prefix);
            return;
        }

        if (pos >= word.size()) return;

        int i = word[pos] - 'a';
        if (node->child[i]) {
            prefix.push_back(word[pos]);
            find_prefixes_helper(node->child[i], word, prefix, pos + 1, res);
        }
    }

    vector<string> findPrefixes(string arr[], int n) {
        Trie trie;
        for (int i = 0; i < n; i++) {
            trie.insert(arr[i]);
        }

        vector<string> res;
        for (int i = 0; i < n; i++) {
            string prefix;
            find_prefixes_helper(trie.root, arr[i], prefix, 0, res);
        }
        return res;
    }
};