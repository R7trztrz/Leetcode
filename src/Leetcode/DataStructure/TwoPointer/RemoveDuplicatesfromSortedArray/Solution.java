package Leetcode.DataStructure.TwoPointer.RemoveDuplicatesfromSortedArray;

/**
 * Use quick pointer to find new element and use slow pointer to build new array.
 *
 * @since 17 / 05 /2026
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        // number of unique
        int k = 1;

        // quick and slow pointer
        int quick;
        int slow = 0;

        // iteration
        for (quick = 1; quick < nums.length; quick++) {
            // new element
            if (nums[quick] != nums[quick - 1]) {
                slow++;
                nums[slow] = nums[quick];
                k++;
            }
        }

        return k;
    }
}
