# PalindromeLinkedList

Given the `head` of a singly linked list, return `true` *if it is a* *palindrome* *or* `false` *otherwise*.

## Solution 1

We can simulate a reverse traversal by pushing each `ListNode` onto a stack and then popping them in order.

```java
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
```

Time complexity: $O(n)$

## Solution 2

Use fast and slow pointer to find the middle of the LinkedList. The fast pointer moves two steps at a time, while the slow pointer moves one step at a time.

Reverse the second half of the list and compare it with the first half. If both halves match, the list is a palindrome.

In each iteration, store `curr.next` in a temporary variable, point `curr.next` to the head of the reversed part, move the reversed head to `curr`, and then advance `curr` to the saved next node.

```java
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
```

Time complexity: $O(n)$

Space complexity: $O(1)$