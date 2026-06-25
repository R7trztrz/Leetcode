package Leetcode.DataStructure.Recursion.ReverseLinkedList;

/**
 *
 * @since 25 / 06 / 2026
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return last;
    }
}
