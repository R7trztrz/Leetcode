package Leetcode.DataStructure.Array.BinarySearch.IsSubsequence;

/**
 *
 * @since 31 / 05 / 2026
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        // pointer s
        int ps = 0;

        // iteration
        for (char c : t.toCharArray()) {
            if (ps >= s.length()) {
                return true;
            } else if (s.charAt(ps) == c) {
                ps++;
            }
        }

        return ps >= s.length();
    }
}
