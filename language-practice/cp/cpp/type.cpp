#include <bits/stdc++.h>
using namespace std;
class Solution {
   public:
    void pushZerosToEnd(vector<int>& arr) {
        // code here
        int left = 0;
        int right = arr.size() - 1;

        while (left < right) {
            if (arr[right] == 0) {
                right--;
            }

            if (arr[left] != 0) {
                left++;
            }

            if (arr[left] == 0 && arr[right] != 0) {
                swap(arr[left], arr[right]);
                left++;
                right--;
            }
        }
    }
};