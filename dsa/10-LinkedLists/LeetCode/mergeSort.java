/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode newLeft = sortList(head);
        ListNode newRight = sortList(rightHead);
        return merge(newLeft, newRight);
    }

    private ListNode getMid(ListNode head) {
        ListNode turtle = head;
        ListNode hare = head.next;

        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
        }

        return turtle;
    }

    private ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode mergedLL = new ListNode(-1);
        ListNode temp = mergedLL;

        while (leftHead != null && rightHead != null) {
            if (leftHead.val <= rightHead.val) {
                temp.next = leftHead;
                leftHead = leftHead.next;
                temp = temp.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }

        while (leftHead != null) {
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }

        while (rightHead != null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }
}