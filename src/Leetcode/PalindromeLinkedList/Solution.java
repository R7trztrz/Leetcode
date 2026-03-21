package Leetcode.PalindromeLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode iterator = head;
        int length = 0;

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
