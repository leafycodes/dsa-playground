#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int minCost(vector<int>& ropes) {
        // minheap
        priority_queue<int, vector<int>, greater<int>> pq;
        // add all ropes
        for (auto rope : ropes) {
            pq.push(rope);
        }

        // remove two and add. until size is 1;
        int min_cost = 0;
        while (pq.size() > 1) {
            int first = pq.top();
            pq.pop();
            int second = pq.top();
            pq.pop();

            min_cost += first + second;
            pq.push(first + second);
        }

        return min_cost;
    }
};