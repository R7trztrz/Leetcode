package Leetcode.DataStructure.TwoPointer.ReverseString;

/**
 *
 * @since 21 / 05 / 2026
 */
class Solution {
    public void reverseString(char[] s) {
        // left and right boundary
        int left = 0;
        int right = s.length - 1;

        // iteration
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
