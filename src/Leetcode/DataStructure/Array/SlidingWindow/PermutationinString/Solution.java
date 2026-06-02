package Leetcode.DataStructure.Array.SlidingWindow.PermutationinString;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @since 25 / 05 / 2026
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // frequency table
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // sliding window
        int left = 0;
        int right = 0;
        int valid = 0;

        // iteration
        while (right < s2.length()) {
            // expend window
            char c = s2.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // shrink window
            while (right - left >= s1.length()) {
                // case 1: right - left == s1.length()
                if (valid == need.size()) {
                    return true;
                }

                //case 2: right - left > s1.length()
                char d = s2.charAt(left);
                left++;

                if(need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }

                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return false;
    }
}
