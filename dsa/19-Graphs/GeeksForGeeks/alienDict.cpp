#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    string findOrder(vector<string>& words) {
        unordered_map<char, unordered_set<char>> graph;
        unordered_map<char, int> in_degree;
        string result;

        if (words.empty()) {
            return result;
        }

        for (const string& word : words) {
            for (char ch : word) {
                in_degree[ch] = 0;
            }
        }

        for (int i = 0; i < words.size() - 1; ++i) {
            const string& curr = words[i];
            const string& next = words[i + 1];
            int min_len = min(curr.size(), next.size());
            int j = 0;
            while (j < min_len && curr[j] == next[j]) {
                ++j;
            }
            if (j < min_len) {
                char from = curr[j];
                char to = next[j];
                if (graph[from].count(to) == 0) {
                    graph[from].insert(to);
                    in_degree[to]++;
                }
            } else if (curr.size() > next.size()) {
                return "";
            }
        }

        queue<char> q;
        for (const auto& entry : in_degree) {
            if (entry.second == 0) {
                q.push(entry.first);
            }
        }

        while (!q.empty()) {
            char current = q.front();
            q.pop();
            result += current;

            for (char neighbor : graph[current]) {
                if (--in_degree[neighbor] == 0) {
                    q.push(neighbor);
                }
            }
        }

        return result.size() == in_degree.size() ? result : "";
    }
};