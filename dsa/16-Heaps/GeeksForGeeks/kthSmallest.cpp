#include <bits/stdc++.h>
using namespace std;

// Function to find kth smallest array element
void kthSmallest(vector<int>& v, int N, int K) {
    // Implement Max Heap using
    // a Priority Queue
    priority_queue<int> heap1;

    for (int i = 0; i < N; ++i) {
        // Insert elements into
        // the priority queue
        heap1.push(v[i]);

        // If size of the priority
        // queue exceeds k
        if (heap1.size() > K) {
            heap1.pop();
        }
    }

    // Print the k-th smallest element
    cout << heap1.top() << endl;
}