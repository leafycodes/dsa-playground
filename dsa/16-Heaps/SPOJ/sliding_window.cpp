#include <bits/stdc++.h>
using namespace std;

// sliding window max
void sliding_window_max(vector<int>& nums, int k) {
    deque<int> dq;
    int n = nums.size();

    // Process first k elements
    for (int i = 0; i < k; i++) {
        while (!dq.empty() && nums[dq.back()] <= nums[i]) {
            dq.pop_back();
        }
        dq.push_back(i);
    }
    cout << nums[dq.front()] << " ";

    // Process rest of the elements
    for (int i = k; i < n; i++) {
        // Remove indices out of window
        while (!dq.empty() && dq.front() <= i - k) {
            dq.pop_front();
        }
        // Remove smaller elements
        while (!dq.empty() && nums[dq.back()] <= nums[i]) {
            dq.pop_back();
        }
        dq.push_back(i);
        cout << nums[dq.front()] << " ";
    }
    cout << endl;
}

int main() {
    vector<int> nums;
    int n, k;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        nums.push_back(temp);
    }
    cin >> k;
    sliding_window_max(nums, k);
    return 0;
}