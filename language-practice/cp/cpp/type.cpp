#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int maxSum(vector<int>& nums) {
        bool all_negative = true;
        int max_negative_element = INT_MIN;
        set<int> s;
        int sum = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] >= 0) {
                all_negative = false;
                if (s.count(nums[i]) == 0) {
                    sum += nums[i];
                    s.insert(nums[i]);
                }
            }

            if (nums[i] < 0) {
                max_negative_element = max(max_negative_element, nums[i]);
            }
        }

        return all_negative ? max_negative_element : sum;
    }
};

int main() {
    vector<int> nums = {1, 2, -1, -2, 1, 0, -1};
    Solution s;
    cout << s.maxSum(nums);
    return 0;
}