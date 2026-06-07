package Leetcode.DataStructure.LinkedList.TwoPointer.LinkedListCycle;

/**
 *
 * @since 08 / 06 / 2026
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // quick and slow pointer
        ListNode quick = head;
        ListNode slow = head;

        // iteration
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;

            if (quick == slow) {
                return true;
            }
        }

        return false;
    }
}
