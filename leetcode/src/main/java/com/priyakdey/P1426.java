package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class P1426 {

    public int countElements(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int elem : arr) {
            freqMap.compute(elem, (k, v) -> v == null ? 1 : v + 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int elem = entry.getKey();
            int freq = entry.getValue();
            if (freqMap.containsKey(elem + 1)) {
                count += freq;
            }
        }

        return count;
    }

}
