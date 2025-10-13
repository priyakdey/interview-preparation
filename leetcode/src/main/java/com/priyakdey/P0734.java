package com.priyakdey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class P0734 {

    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2,
                                       List<List<String>> similarPairs) {
        Map<String, String> map = new HashMap<>();
        for (List<String> similarPair : similarPairs) {
            map.put(similarPair.get(0), similarPair.get(1));
            map.put(similarPair.get(1), similarPair.get(0));
        }

        if (sentence1.length != sentence2.length) return false;

        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];

            if (!Objects.equals(word1, word2) && !Objects.equals(map.get(word1), word2)
                    && !Objects.equals(map.get(word2), word1)) {
                return false;
            }
        }

        return true;
    }

}
