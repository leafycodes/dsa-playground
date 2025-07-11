#include <bits/stdc++.h>
using namespace std;

int main() {
    string str;
    getline(cin, str);
    int n = str.length();

    if (n == 1) {
        cout << 1;
        return 0;
    }

    int max_count = 1;
    int curr_count = 1;
    char prev = str[0];
    for (int i = 1; i < n; i++) {
        if (str[i] == prev) {
            curr_count += 1;
        } else {
            curr_count = 1;
        }

        max_count = max(max_count, curr_count);
        prev = str[i];
    }

    cout << max_count;

    return 0;
}

// CSES