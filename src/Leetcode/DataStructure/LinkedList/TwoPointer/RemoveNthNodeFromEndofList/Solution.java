package Leetcode.DataStructure.LinkedList.TwoPointer.RemoveNthNodeFromEndofList;

/**
 *
 * @since 04 / 06 / 2026
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // initialization answer
        ListNode answer = new ListNode(-1);
        answer.next = head;

        // fast and slow pointer
        ListNode fast = answer;
        ListNode slow = answer;

        // iteration
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // remove
        slow.next = slow.next.next;

        return answer.next;
    }
}
