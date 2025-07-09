// Minimum time required to fill given N slots
// Given an integer N which denotes the number of slots, and an array arr[]
// consisting of K integers in the range [1, N] . Each element of the array are
// in the range [1, N] which represents the indices of the filled slots. At each
// unit of time, the index with filled slot fills the adjacent empty slots. The
// task is to find the minimum time taken to fill all the N slots.

// Examples:

// Input: N = 6, K = 2, arr[] = {2, 6}
// Output: 2
// Explanation:
// Initially there are 6 slots and the indices of the filled slots are slots[] =
// {0, 2, 0, 0, 0, 6}, where 0 represents unfilled. After 1 unit of time,
// slots[] = {1, 2, 3, 0, 5, 6} After 2 units of time, slots[] = {1, 2, 3, 4, 5,
// 6} Therefore, the minimum time required is 2.

// Input : N = 5, K = 5, arr[] = {1, 2, 3, 4, 5} Output : 0

#include <bits/stdc++.h>
using namespace std;

void min_time(vector<int>& nums, int n, int k) {
    queue<int> q;
    bool visited[n + 1];
    int time = 0;

    for (int i = 0; i < k; i++) {
        q.push(nums[i]);
        visited[nums[i]] = true;
    }

    while (q.size() >
           0) {  // Each iteration of this loop represents one unit of time
        for (int i = 0; i < q.size();
             i++) {  // loop processes all the positions that were filled in the
                     // previous time unit
            int curr = q.front();
            q.pop();

            if (curr - 1 >= 1 && !visited[curr - 1]) {
                visited[curr - 1] = true;
                q.push(curr - 1);
            }

            if (curr + 1 <= n && !visited[curr + 1]) {
                visited[curr + 1] = true;
                q.push(curr + 1);
            }
        }

        time++;  // incremented one extra time after all slots have already been
                 // filled.

        // after the last slot is filled, the time variable is still incremented
        // once more before the loop exits.
    }

    cout << time - 1;
}

int main() {
    int N = 6;
    vector<int> arr = {2, 6};
    int K = arr.size();

    min_time(arr, N, K);
    return 0;
}
