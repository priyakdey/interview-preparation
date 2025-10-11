package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class DecodeWays {

    public int numDecodings(String s) {
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            map.put(i, (char) (i + 64));
        }

        int length = s.length();
        Integer[] cache = new  Integer[length + 1];
        return numDecodings(s, 0, cache, map);
    }

    private int numDecodings(String s, int index, Integer[] cache, Map<Integer, Character> map) {
        if (index == s.length()) return 1;
        char ch1 = s.charAt(index);
        int digit1 = ch1 - '0';
        if (!map.containsKey(digit1)) return 0;

        if (cache[index] != null) return cache[index];

        int ways = numDecodings(s, index + 1, cache, map);

        if (index  + 1 < s.length()) {
            char ch2 = s.charAt(index + 1);
            int digit2 = ch2 - '0';
            if (map.containsKey(digit1 * 10 + digit2)) {
                ways += numDecodings(s, index + 2, cache, map);
            }
        }

        cache[index] = ways;
        return ways;
    }
}
