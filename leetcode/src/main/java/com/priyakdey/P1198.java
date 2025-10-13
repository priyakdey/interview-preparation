package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class P1198 {

    public int smallestCommonElement(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int element = mat[row][col];
                freqMap.compute(element, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        int minElement = -1;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int element = entry.getKey();
            int freq = entry.getValue();
            if (freq == rows && (minElement == -1 || element < minElement)) {
                minElement = element;
            }
        }

        return minElement;
    }

}
