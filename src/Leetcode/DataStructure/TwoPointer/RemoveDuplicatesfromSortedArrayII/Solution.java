package Leetcode.DataStructure.TwoPointer.RemoveDuplicatesfromSortedArrayII;

/**
 *
 * @since 05 / 23 / 2026
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        // int counter
        int counter = 0;

        // quick and slow pointer
        int quick = 0;
        int slow = 0;

        // iteration
        while (quick < nums.length) {
            // new element
            if (nums[quick] != nums[slow]) {
                slow++;
                nums[slow] = nums[quick];
            // element that appear less than 3 times
            } else if (quick > slow && counter < 2) {
                slow++;
                nums[slow] = nums[quick];
            }

            quick++;
            counter++;

            if (quick < nums.length && nums[quick] != nums[quick - 1]) {
                counter = 0;
            }
        }

        return slow + 1;
    }
}
