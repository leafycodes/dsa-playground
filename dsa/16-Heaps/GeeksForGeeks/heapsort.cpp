// The functions should be written in a way that array become sorted
// in increasing order when heapSort() is called.
#include <bits/stdc++.h>
using namespace std;

class Solution {
   private:
    void heapify(vector<int>& arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            // swap
            swap(arr[maxIdx], arr[i]);
            heapify(arr, maxIdx, size);
        }
    }

   public:
    // Function to sort an array using Heap Sort.
    void heapSort(vector<int>& arr) {
        // code here
        int n = arr.size();
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // push to end

        for (int i = n - 1; i > 0; i--) {
            swap(arr[0], arr[i]);
            heapify(arr, 0, i);
        }
    }
};