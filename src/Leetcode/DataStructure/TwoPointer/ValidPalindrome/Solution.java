package Leetcode.DataStructure.TwoPointer.ValidPalindrome;

/**
 *
 * @since 24 / 05 / 2026
 */
class Solution {
    public boolean isPalindrome(String s) {
        // processing string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        // find midpoint and initialize pointer
        int left;
        int right;

        if (sb.length() % 2 == 0) {
            left = (sb.length() / 2) - 1;
            right = left + 1;
        } else {
            left = sb.length() / 2;
            right = left;
        }

        // check
        while (left >=0 && right < sb.length()) {
            if (sb.charAt(left) == sb.charAt(right)) {
                left--;
                right++;
            } else {
                return false;
            }
        }

        return true;
    }
}
