package Leetcode.DataStructure.Hashing.LongestConsecutiveSequence;

import java.util.HashSet;

/**for (int i : nums) -> O(n)
 * for (int i : set) nest while (set.contains(currentNum + 1)) -> 2n -> O(n)
 *
 * @since 25 / 06 / 2026
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        int maxLength = 0;

        for (int i : set) {
            if (set.contains(i - 1)) {
                continue;
            }

            int currentLength = 1;
            int currentNum = i;

            while (set.contains(currentNum + 1)) {
                currentNum++;
                currentLength++;
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
