#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for singly-linked list.
 * struct ListNode {
 * int val;
 * ListNode *next;
 * ListNode() : val(0), next(nullptr) {}
 * ListNode(int x) : val(x), next(nullptr) {}
 * ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class compare {
   public:
    bool operator()(ListNode* a, ListNode* b) { return a->val > b->val; }
};

class Solution {
   public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>, compare> pq;

        // Push all initial nodes into the priority queue
        for (ListNode* list : lists) {
            if (list != nullptr) {
                pq.push(list);
            }
        }

        ListNode* dummy = new ListNode(-1);  // Dummy node to simplify insertion
        ListNode* tail = dummy;

        while (!pq.empty()) {
            ListNode* curr = pq.top();
            pq.pop();

            tail->next = curr;
            tail = tail->next;

            if (curr->next != nullptr) {
                pq.push(curr->next);
            }
        }

        ListNode* head = dummy->next;
        delete dummy;
        return head;
    }
};