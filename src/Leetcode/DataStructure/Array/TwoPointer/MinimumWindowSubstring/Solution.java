package Leetcode.DataStructure.Array.TwoPointer.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @since 20 / 05 / 2026
 */
class Solution {
    public String minWindow(String s, String t) {

        // window
        int leftBound = 0;
        int rightBound = 0;

        // initial frequency table
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // number of valid char
        int valid = 0;

        // start of the substring and length
        int start = 0;
        int len = Integer.MAX_VALUE;

        // iteration
        while (rightBound < s.length()) {
            char c = s.charAt(rightBound);
            // expand window
            rightBound++;

            // Only update the window count if c is a character we care about.
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // If the window now has exactly the required number of c,
                // then this character's requirement is fulfilled.
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // shrink window
            while (valid == need.size()) {
                // update when current window is smaller than previously minimum window
                if (rightBound - leftBound < len) {
                    start = leftBound;
                    len = rightBound - leftBound;
                }

                char d = s.charAt(leftBound);
                leftBound++;

                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }

                    window.put(d, window.get(d) - 1);
                }
            }

        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
