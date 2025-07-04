// This is from LGSI: LG Soft India Coding round (2/2) only asked for c/c++

// in short, take n inputs and return an array that is in a aweay that no two adjacent elements are same. i.e
//  8
//  1 1 1 1 2 2 3 3
// returns ----> 1 2 1 2 1 3 1 3

// if multiple answer, return any one of them

#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>
using namespace std;

vector<int> rearrange_array(vector<int> &nums)
{
    unordered_map<int, int> freq_map;
    for (int num : nums)
    {
        freq_map[num]++;
    }

    priority_queue<pair<int, int>> max_heap;
    for (auto &entry : freq_map)
    {
        max_heap.push(make_pair(entry.second, entry.first));
    }

    vector<int> result;
    while (!max_heap.empty())
    {
        pair<int, int> current = max_heap.top();
        max_heap.pop();
        int current_count = current.first;
        int current_num = current.second;

        if (result.empty() || result.back() != current_num)
        {
            result.push_back(current_num);
            if (--current_count > 0)
            {
                max_heap.push(make_pair(current_count, current_num));
            }
        }
        else
        {
            if (max_heap.empty())
            {
                return {};
            }

            pair<int, int> next = max_heap.top();
            max_heap.pop();
            int next_count = next.first;
            int next_num = next.second;

            result.push_back(next_num);
            if (--next_count > 0)
            {
                max_heap.push(make_pair(next_count, next_num));
            }
            max_heap.push(make_pair(current_count, current_num));
        }
    }

    return result;
}

int main()
{
    int n;
    cin >> n;
    vector<int> nums(n);
    for (int i = 0; i < n; i++)
    {
        cin >> nums[i];
    }

    vector<int> result = rearrange_array(nums);
    for (int num : result)
    {
        cout << num << " ";
    }

    return 0;
}