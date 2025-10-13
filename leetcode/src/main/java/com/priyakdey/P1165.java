package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class P1165 {

    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }

        int totalTime = 0;
        int curr = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int next = map.get(ch);
            totalTime += Math.abs(curr - next);
            curr = next;
        }

        return totalTime;
    }

}
