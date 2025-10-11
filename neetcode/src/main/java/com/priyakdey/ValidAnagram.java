package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char ch : s.toCharArray()) {
            counter.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!counter.containsKey(ch)) {
                return false;
            }
            counter.computeIfPresent(ch, (k, v) -> v == 1 ? null : v - 1);
        }

        return counter.isEmpty();
    }

}
