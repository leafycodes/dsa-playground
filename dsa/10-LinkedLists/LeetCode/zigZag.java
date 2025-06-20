/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode getMid(ListNode head) {
        ListNode turtle = head;
        ListNode hare = head.next;

        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
        }

        return turtle;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode mid = getMid(head);

        ListNode curr = mid.next;
        mid.next = null;

        ListNode rightHead = reverse(curr);
        ListNode leftHead = head;

        ListNode nextL, nextR;
        while (leftHead != null && rightHead != null) {
            nextL = leftHead.next;
            leftHead.next = rightHead;
            nextR = rightHead.next;
            rightHead.next = nextL;

            rightHead = nextR;
            leftHead = nextL;
        }
    }
}