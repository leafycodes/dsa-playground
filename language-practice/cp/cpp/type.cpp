#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    long long total = 1LL * n * (n + 1) / 2;
    long long sum = 0;
    for (int i = 0; i < n - 1; i++) {
        int temp;
        cin >> temp;
        sum += temp;
    }
    cout << total - sum << endl;
    return 0;
}

// CSES