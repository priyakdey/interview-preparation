package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class P0734 {

    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2,
                                       List<List<String>> similarPairs) {
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> similarPair : similarPairs) {
            String word1 = similarPair.getFirst();
            String word2 = similarPair.getLast();
            if (!map.containsKey(word1)) {
                map.put(word1, new HashSet<>());
            }
            map.get(word1).add(word2);

            if (!map.containsKey(word2)) {
                map.put(word2, new HashSet<>());
            }
            map.get(word2).add(word1);
        }

        if (sentence1.length != sentence2.length) return false;

        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];

            if (Objects.equals(word1, word2)) continue;
            if (map.containsKey(word1) && map.get(word1).contains(word2)) continue;
            if (map.containsKey(word2) && map.get(word2).contains(word1)) continue;

            return false;
        }


        return true;
    }

}
