package Leetcode.DataStructure.Array.BinarySearch.SearchInsertPosition;

/**
 *
 * @since 02 / 06 / 2026
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        // left and right pointer
        int left = 0;
        int right = nums.length - 1;

        // binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
