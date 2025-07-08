class Solution {
    public static void heapify(int[] arr, int i, int size) {
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

            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            // heapify
            heapify(arr, maxIdx, size);
        }
    }

    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[]) {
        // code here
        int n = arr.length;

        // maxheap for ascending and minheap for descending
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n); // initial heapify
        }

        // push largest at the end of The array

        for (int i = n - 1; i > 0; i--) {
            // swap first and last (1st is maxHeap top)

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i); // now heapify top down form 0 to bottom and size of heap is i
        }
    }
}