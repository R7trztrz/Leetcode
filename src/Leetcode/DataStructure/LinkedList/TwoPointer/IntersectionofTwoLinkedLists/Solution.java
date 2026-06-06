package Leetcode.DataStructure.LinkedList.TwoPointer.IntersectionofTwoLinkedLists;

/**
 *
 * @since 07 / 06 / 2026
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // two pointer
        ListNode pA = headA;
        ListNode pB = headB;

        // iteration
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }

            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }

        return pA;
    }
}
