// i have done this in java with deque in leetcode and cpp for SPOJ, now redo in
// cpp using priorityqueues. same logic for java, just rememeber that java is
// minheap by default and cpp is maxheap by default

#include <bits/stdc++.h>
using namespace std;
#define pii pair<int, int>

class compare {
   public:
    bool operator()(pii& a, pii& b) { return a.second < b.second; }
};
class Solution {
   public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        priority_queue<pii, vector<pii>, compare> pq;
        for (int i = 0; i < k; i++) {
            pq.push({i, nums[i]});
        }

        vector<int> res(nums.size() - k + 1);
        res[0] = pq.top().second;
        for (int i = k; i < nums.size(); i++) {
            while (pq.size() > 0 && pq.top().first <= i - k) {
                pq.pop();
            }

            pq.push(make_pair(i, nums[i]));
            res[i - k + 1] = pq.top().second;
        }

        return res;
    }
};