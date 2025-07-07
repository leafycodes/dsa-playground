#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int maxEvents(vector<vector<int>>& events) {
        if (events.empty()) {
            return 0;
        }

        sort(events.begin(), events.end());

        priority_queue<int, vector<int>, greater<int>> min_heap;
        int max_events = 0;
        int i = 0;
        int n = events.size();
        int current_day = 0;

        while (!min_heap.empty() || i < n) {
            if (min_heap.empty()) {
                current_day = events[i][0];
            }

            while (i < n && events[i][0] <= current_day) {
                min_heap.push(events[i][1]);
                i++;
            }

            min_heap.pop();
            max_events++;
            current_day++;

            while (!min_heap.empty() && min_heap.top() < current_day) {
                min_heap.pop();
            }
        }

        return max_events;
    }
};