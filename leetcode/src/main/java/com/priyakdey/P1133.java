package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class P1133 {

    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }

        int maxValue = -1;

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int element = entry.getKey();
            int freq = entry.getValue();
            if (freq == 1) {
                maxValue = Math.max(maxValue, element);
            }
        }

        return maxValue;
    }

}
