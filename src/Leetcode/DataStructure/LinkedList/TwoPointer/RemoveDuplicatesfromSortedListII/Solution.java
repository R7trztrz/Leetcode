package Leetcode.DataStructure.LinkedList.TwoPointer.RemoveDuplicatesfromSortedListII;

/**
 *
 * @since 09 / 06 / 2026
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // initialization list
        ListNode unique = new ListNode(-101);
        ListNode duplicate = new ListNode(-101);

        ListNode pUnique = unique;
        ListNode pDuplicate = duplicate;
        ListNode iterator = head;

        // iteration
        while (iterator != null) {
            if (iterator.next != null && iterator.val == iterator.next.val || iterator.val == pDuplicate.val) {
                pDuplicate.next = iterator;
                pDuplicate = pDuplicate.next;
            } else {
                pUnique.next = iterator;
                pUnique = pUnique.next;
            }

            iterator = iterator.next;
            pUnique.next = null;
            pDuplicate.next = null;
        }

        return unique.next;
    }
}
