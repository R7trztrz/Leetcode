package Leetcode.DataStructure.StackAndQueue.NextGreaterElementI;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @since 22 / 06 / 2026
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        int[] greater = findNextGreater(nums2);
        HashMap<Integer, Integer> greaterMap = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            greaterMap.put(nums2[i], greater[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            answer[i] = greaterMap.get(nums1[i]);
        }

        return answer;
    }

    private int[] findNextGreater(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            // empty: no greater element
            while (!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            res[i] = stack.empty() ? -1 : stack.peek();

            stack.push(nums[i]);
        }

        return res;
    }
}
