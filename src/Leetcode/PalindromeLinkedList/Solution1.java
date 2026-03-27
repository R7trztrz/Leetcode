package Leetcode.PalindromeLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution1 {
    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode iterator = head;

        while (iterator != null) {
            stack.push(iterator);
            iterator = iterator.next;
        }

        while (!stack.isEmpty()) {
            iterator = stack.pop();
            if (head.val != iterator.val) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
}
