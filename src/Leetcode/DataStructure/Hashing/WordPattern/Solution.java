package Leetcode.DataStructure.Hashing.WordPattern;

import java.util.HashMap;
import java.util.HashSet;

/**1. new pattern, new word -> build mapping, continue
 * 2. new pattern, old word -> false
 * 3. old pattern, new word -> false
 * 4. old pattern, old word but not equal to mapping -> false
 * 5. old pattern, pld word and equal to mapping -> continue
 *
 * @since 24 / 06 / 2026
 */
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> patternToWord = new HashMap<>();
        HashSet<String> wordSet = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // new pattern
            if (!patternToWord.containsKey(c)) {
                // old word
                if (wordSet.contains(word)) {
                    return false;
                }
                // new pattern, new word, store
                patternToWord.put(c, word);
            // old pattern
            } else {
                // old word but not equal or new word
                if (!patternToWord.get(c).equals(word)) {
                    return false;
                }
            }

            wordSet.add(word);
        }

        return true;
    }
}
