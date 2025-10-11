package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();

        int maxLength = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch =  s.charAt(i);
            if (indexMap.containsKey(ch) && indexMap.get(ch) >= start) {
                int length = i - start;
                maxLength = Math.max(maxLength, length);
                start = indexMap.get(ch) + 1;
            }

            indexMap.put(ch, i);
        }

        return Math.max(maxLength, s.length() - start);
    }

}
