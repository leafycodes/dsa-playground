#include <bits/stdc++.h>
using namespace std;

int main() {
    string str;
    getline(cin, str);

    int count = 0;
    queue<char> q;
    for (int i = 0; i < str.length(); i++) {
        if (str[i] == '`' && q.empty()) {
            q.push(str[i]);
        } else if (str[i] == '`') {
            q.pop();
            count++;
        }
    }

    cout << count;
    return 0;
}