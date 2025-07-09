#include <bits/stdc++.h>
#define PII pair<int, int>
using namespace std;

class compare {
    // When true is returned, it means the order is NOT correct and
    // swapping of elements takes place.
    // When false is returned, it means the order is correct and NO swapping of
    // elements takes place.
   public:
    bool operator()(PII& a, PII& b) {
        if (a.second == b.second) {
            return a.first > b.first;
        } else {
            return a.second > b.second;
        }
    }
};

class Solution {
   public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        priority_queue<PII, vector<PII>, compare> pq;
        for (int i = 0; i < mat.size(); i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[0].size(); j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                soldiers += 1;
            }
            pq.push({i, soldiers});
        }

        vector<int> res;
        for (int i = 0; i < k; i++) {
            res.push_back(pq.top().first);
            pq.pop();
        }

        return res;
    }
};