package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class P0249 {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String s = shift(str);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String shift(String word) {
        int shift = word.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder(word.length());

        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - shift;
            if (k < 97) k += 26;
            sb.append((char) k);
        }

        return sb.toString();
    }

}
