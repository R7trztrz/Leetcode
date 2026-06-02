package Leetcode.DataStructure.Array.TwoPointer.LongestPalindromicSubstring;

/**
 *
 * @since 22 / 05 / 2026
 */
class Solution {
    public String longestPalindrome(String s) {
        String answer = "";

        // iteration
        for (int i = 0; i < s.length(); i++) {
            String s1 = findPalindrome(s, i, i);
            String s2 = findPalindrome(s, i, i + 1);

            answer = s1.length() > answer.length() ? s1 : answer;
            answer = s2.length() > answer.length() ? s2 : answer;
        }

        return answer;
    }

    public String findPalindrome(String s, int left, int right) {
        // Expand from the center to the left and right
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // substring(a, b) -> [a, b)
        return s.substring(left + 1, right);
    }
}
