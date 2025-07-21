#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    string removeDuplicates(string str, int k) {
        stack<pair<char, int>> s;

        for (int i = 0; i < str.length(); ++i) {
            if (s.empty() || s.top().first != str[i]) {
                s.push({str[i], 1});
            } else {
                ++s.top().second;

                if (s.top().second >= k) {
                    s.pop();
                }
            }
        }

        string res;
        while (!s.empty()) {
            pair<char, int> curr = s.top();
            s.pop();

            for (int i = 0; i < curr.second; i++) {
                res += curr.first;
            }
        }

        reverse(res.begin(), res.end());
        return res;
    }
};

int main() {
    string str;
    cin >> str;
    Solution s;
    cout << s.removeDuplicates("deeedbbcccbdaa", 3);
    return 0;
}