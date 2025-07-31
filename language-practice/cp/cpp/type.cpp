#include <algorithm>
#include <iostream>
#include <map>
#include <vector>
using namespace std;

void helper() {
    int n;
    cin >> n;
    vector<int> nums(n);
    map<int, int> freq;
    long long total_sum = 0;

    for (int i = 0; i < n; i++) {
        cin >> nums[i];
        freq[nums[i]]++;
        total_sum += nums[i];
    }

    long long score = total_sum;

    for (int i = 0; i <= 50; i++) {
        long long curr = 0;
        bool form_mex = true;

        for (int j = 0; j < i; j++) {
            if (freq[j] == 0) {
                form_mex = false;
                break;
            }
        }

        if (form_mex) {
            curr += i;
            for (auto const& f : freq) {
                int val = f.first;
                int cnt = f.second;

                if (val >= i) {
                    curr += (long long)val * cnt;
                } else {
                    curr += (long long)val * (cnt - 1);
                }
            }

            score = max(score, curr);
        }
    }

    cout << score << endl;
}

int main() {
    int t;
    cin >> t;
    while (t-- > 0) {
        helper();
    }

    return 0;
}