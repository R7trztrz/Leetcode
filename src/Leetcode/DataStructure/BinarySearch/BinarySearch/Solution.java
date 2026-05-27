package Leetcode.DataStructure.BinarySearch.BinarySearch;

/**
 *
 * @since 28 / 05 / 2026
 */
class Solution {
    public int search(int[] nums, int target) {
        // left and right pointer
        int left = 0;
        int right = nums.length - 1;

        // iteration
        while (left <= right) {
            // avoid int overflow
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
