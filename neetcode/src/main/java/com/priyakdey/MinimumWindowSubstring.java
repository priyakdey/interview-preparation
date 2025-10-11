package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class MinimumWindowSubstring {


    public String minWindow(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0, minLength = Integer.MAX_VALUE, minLeft = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (map1.containsKey(ch)) {
                map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            }
            right++;

            while (containsAll(map1, map2)) {
                if (right - left < minLength) {
                    minLength = right - left;
                    minLeft = left;
                }
                char leftChar = s.charAt(left);
                if (map1.containsKey(leftChar)) {
                    map2.put(leftChar, map2.get(leftChar) - 1);
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }

    private boolean containsAll(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (map2.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

}
