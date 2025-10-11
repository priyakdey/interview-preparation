package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class GroupAnagrams {

    private final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> map = new HashMap<>();

        for (String str : strs) {
            long hash = calcHash(str);
            map.computeIfAbsent(hash, (_) -> new ArrayList<>())
                    .add(str);
        }

        return new ArrayList<>(map.values());
    }

    private long calcHash(String str) {
        long hash = 5381;
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            hash = hash * primes[index] + hash;
        }
        return hash;
    }

}
