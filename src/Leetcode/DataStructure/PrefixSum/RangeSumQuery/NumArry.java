package Leetcode.DataStructure.PrefixSum.RangeSumQuery;

/**
 * The prefix sum technique is used to quickly and repeatedly calculate
 * the sum of elements in a range of indices.
 *
 * preSums[i] stores the sum of nums[0 ... i-1].
 *
 * @since 10 / 05 / 2026
 */
class NumArry {
    private int[] preSums;

    public NumArry(int[] nums) {
        buildPreSums(nums);
    }

    public void buildPreSums(int[] nums) {
        preSums = new int[nums.length + 1];

        for (int i = 1; i < nums.length + 1; i++) {
            this.preSums[i] = preSums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSums[right + 1] - preSums[left];
    }
}
