/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode turtle = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;

            if (turtle == hare) {
                turtle = head;
                int i = 0;
                while (turtle != hare) {
                    turtle = turtle.next;
                    hare = hare.next;
                    i++;
                }
                return turtle;
            }
        }
        return null;
    }
}