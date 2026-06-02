package Leetcode.DataStructure.LinkedList.TwoPointer.MergeTwoSortedLists;

/**
 *
 * @since 03 / 06 / 2026
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // two pointer
        ListNode pl1 = list1;
        ListNode pl2 = list2;

        // initialize answer
        ListNode answer = new ListNode(-1);
        ListNode tail = answer;

        // sort
        while (pl1 != null && pl2 != null) {
            if (pl1.val > pl2.val) {
                tail.next = pl2;
                pl2 = pl2.next;
            } else {
                tail.next = pl1;
                pl1 = pl1.next;
            }

            tail = tail.next;
        }

        if (pl1 != null) {
            tail.next = pl1;
        }

        if (pl2 != null) {
            tail.next = pl2;
        }

        return answer.next;
    }
}
