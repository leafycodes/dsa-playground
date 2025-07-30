#include <bits/stdc++.h>
using namespace std;

bool split(string& s, int n, int min_score, int k) {
    int cnt = 0;
    int i = 0;
    while (i < n) {
        int cz = 0;
        int co = 0;
        int j = i;
        while (j < n) {
            if (s[j] == '0') {
                ++cz;
            } else {
                ++co;
            }

            if (cz + co >= min_score) {
                break;
            }
            j++;
        }

        if (cz + co < min_score) {
            break;
        }
        cnt++;
        i = j + 1;
    }

    return cnt >= k;
}

int max_score(string s, int n, int k) {
    int left = 1;
    int right = n;
    int res = 0;

    while (left <= right) {
        int mid = (left + right) / 2;
        if (split(s, n, mid, k)) {
            res = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return res;
}

void helper() {
    int n, k;
    string s;
    cin >> n >> k;
    cin >> s;

    cout << max_score(s, n, k) << endl;
}

int main() {
    int t;
    cin >> t;
    while (t-- > 0) {
        helper();
    }

    return 0;
}
