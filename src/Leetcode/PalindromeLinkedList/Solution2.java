package Leetcode.PalindromeLinkedList;

class Solution {
    public boolean isPalindrome(ListNode head) {
        // quick & slow pointer
        ListNode slow = head;
        ListNode quick = head.next;

        // iterate
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }

        // reverse
        ListNode iterator = slow.next;
        slow.next = null;
        ListNode reverseHead = null;
        while (iterator != null) {
            ListNode temp = iterator.next;
            iterator.next = reverseHead;
            reverseHead = iterator;
            iterator = temp;
        }

        // verify
        while (reverseHead != null) {
            if (head.val == reverseHead.val) {
                head = head.next;
                reverseHead = reverseHead.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
