#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

void helper() {
    int n, c;
    cin >> n >> c;
    vector<int> a(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    sort(a.begin(), a.end());
    long long res = 0;
    long long multiplier = 1;
    for (int i = 0; i < n; i++) {
        long long cost = (long long)(a[i] * (1LL << i));
        if (cost > c) {
            res++;
        }
    }

    cout << res << endl;
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        helper();
    }

    return 0;
}