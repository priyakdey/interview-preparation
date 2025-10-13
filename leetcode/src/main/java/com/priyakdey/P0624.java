package com.priyakdey;

import java.util.List;

/**
 * @author Priyak Dey
 */
public class P0624 {

    public int maxDistance(List<List<Integer>> arrays) {
        int size = arrays.size();
        int maxDistance = 0;

        int minTillNow = arrays.getFirst().getFirst();
        int maxTillNow = arrays.getFirst().getLast();

        for (int i = 1; i < size; i++) {
            List<Integer> list = arrays.get(i);
            int currMax = list.getLast();
            int currMin = list.getFirst();

            maxDistance = Math.max(maxDistance, Math.max(Math.abs(maxTillNow - currMin),
                    Math.abs(currMax - minTillNow)));
            maxTillNow = Math.max(maxTillNow, currMax);
            minTillNow = Math.min(minTillNow, currMin);
        }

        return maxDistance;
    }

}
