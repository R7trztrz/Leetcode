package Leetcode.DataStructure.LinkedList.TwoPointer.MiddleoftheLinkedList;

/**
 *
 * @since 06 / 06 / 2026
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        // quick and slow pointer
        ListNode quick = head;
        ListNode slow = head;

        // iteration
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
