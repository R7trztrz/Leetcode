package Leetcode.DataStructure.LinkedList.TwoPointer.PartitionList;

/**
 *
 * @since 03 / 06 / 2026
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        // two pointer
        ListNode lessList = new ListNode(-1);
        ListNode lessListTail = lessList;
        ListNode greaterOrEqualList = new ListNode(-1);
        ListNode greaterOrEqualListTail = greaterOrEqualList;

        // iterator
        ListNode iterator = head;

        // iteration
        while (iterator != null) {
            if (iterator.val < x) {
                lessListTail.next = iterator;
                lessListTail = lessListTail.next;
            } else {
                greaterOrEqualListTail.next = iterator;
                greaterOrEqualListTail = greaterOrEqualListTail.next;
            }

            // process iterator
            ListNode temp = iterator.next;
            iterator.next = null;
            iterator = temp;
        }

        // merge
        lessListTail.next = greaterOrEqualList.next;

        return lessList.next;
    }
}
