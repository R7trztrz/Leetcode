package Leetcode.IntersectionofTwoLinkedLists;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode iteratorA = headA;
        ListNode iteratorB = headB;

        // If there is no intersection, the loop will stop when null == null.
        while (iteratorA != iteratorB) {
            if (iteratorA != null) {
                iteratorA = iteratorA.next;
            } else {
                iteratorA = headB;
            }
            if (iteratorB != null) {
                iteratorB = iteratorB.next;
            } else {
                iteratorB = headA;
            }
        }
        return iteratorA;
    }
}
