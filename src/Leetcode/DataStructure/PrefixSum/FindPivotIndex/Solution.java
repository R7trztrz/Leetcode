package Leetcode.DataStructure.PrefixSum.FindPivotIndex;

/**
 * With the prefix-sum array preSum, we can efficiently compute the sum of all elements to the left
 * or right of any index in nums.
 *
 * @since 11 / 05 / 2026
 */
class Solution {
    public int pivotIndex(int[] nums) {

        // Build prefix sums array
        int[] preSums = new int[nums.length + 1];

        for (int i = 1; i < nums.length + 1; i++) {
            preSums[i] = preSums[i - 1] + nums[i - 1];
        }

        // Find Pivot Index
        // left
        int leftSum = 0;
        // right
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum = preSums[i];
            rightSum = preSums[nums.length] - preSums[i] - nums[i];

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}
