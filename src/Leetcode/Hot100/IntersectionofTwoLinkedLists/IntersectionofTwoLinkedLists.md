# Intersection of Two Linked Lists

Given the heads of two singly linked-lists `headA` and `headB`, return *the node at which the two lists intersect*. If the two linked lists have no intersection at all, return `null`.

For example, the following two linked lists begin to intersect at node `c1`:

![img](C:\Project\Leetcode\Leetcode\src\Leetcode\IntersectionofTwoLinkedLists\IntersectionofTwoLinkedLists.assets\160_statement.png)

The test cases are generated such that there are no cycles anywhere in the entire linked structure.

**Note** that the linked lists must **retain their original structure** after the function returns.

**Constraints:**

- The number of nodes of `listA` is in the `m`.
- The number of nodes of `listB` is in the `n`.
- `1 <= m, n <= 3 * 104`
- `1 <= Node.val <= 105`
- `0 <= skipA <= m`
- `0 <= skipB <= n`
- `intersectVal` is `0` if `listA` and `listB` do not intersect.
- `intersectVal == listA[skipA] == listB[skipB]` if `listA` and `listB` intersect.

## Solution

Use two pointers. One starts at `headA` and the other at `headB`**.** When a pointer reaches the end of a list, it switches to the head of the other list. If there is no intersection, both pointers will have traversed A+B and will reach the end at the same time.

```java
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
```

Time complexity: `iteratorA` iterates through list A and list B. `iteratorB` iterates through list B and list A. In the worst case, the `while` loop will stop when both iterators reach the end. Time complexity is $O(m+n)$.