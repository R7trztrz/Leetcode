package Leetcode.DataStructure.StackAndQueue.DailyTemperatures;

import java.util.Stack;

/**
 *
 * @since 22 / 06 / 2026
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] waitDay = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.empty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            waitDay[i] = stack.empty()? 0 : stack.peek() - i;

            stack.push(i);
        }

        return waitDay;
    }
}
