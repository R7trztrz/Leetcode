package Leetcode.DataStructure.TwoPointer.RemoveElement;

/**
 *
 * @since 19 / 05 / 2026
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        // number of value not equal to val
        int k = 0;

        // quick and slow pointer
        int quick;
        int slow = 0;

        // iteration
        for (quick = 0; quick < nums.length; quick++) {
            if (nums[quick] != val) {
                nums[slow] = nums[quick];
                k++;
                slow++;
            }
        }

        return k;
    }
}
