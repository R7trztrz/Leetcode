package Leetcode.DataStructure.Array.SlidingWindow.ContainsDuplicateII;

import java.util.HashSet;

/**
 *
 * @since 27 / 05 / 2026
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // left and right pointer
        int left = 0;
        int right = 0;

        // initialize window
        HashSet<Integer> window = new HashSet<>();

        //iteration
        while (right < nums.length) {
            if (window.contains(nums[right])) {
                return true;
            }

            // expend window
            window.add(nums[right]);
            right++;

            // shrink windwo
            if (right - left > k) {
                window.remove(nums[left]);
                left++;
            }
        }

        return false;
    }
}
