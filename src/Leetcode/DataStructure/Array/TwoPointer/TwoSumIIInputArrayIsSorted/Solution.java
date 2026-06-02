package Leetcode.DataStructure.Array.TwoPointer.TwoSumIIInputArrayIsSorted;

/**
 *
 * @since 20 / 5 / 2026
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int sum = 0;

        //left and right pointer
        int left = 0;
        int right = numbers.length - 1;

        // iteration
        while (left < right) {
            sum = numbers[left] + numbers[right];

            if (sum == target) {
                answer[0] = left + 1;
                answer[1] = right + 1;
                return answer;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return null;
    }
}
