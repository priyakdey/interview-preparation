package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class P0265 {

    public int minCostII(int[][] costs) {
        int[][] cache = new int[costs.length + 1][costs[0].length + 2];
        for (int i = 0; i < costs.length; i++) {
            Arrays.fill(cache[i], -1);
        }

        return minCostII(costs, 0, -1, cache);
    }

    private int minCostII(int[][] costs, int index, int prevColor, int[][] cache) {
        if (index == costs.length) return 0;

        // +1 to offset the -1 indicator for first house
        if (cache[index][prevColor + 1] != -1) {
            return cache[index][prevColor + 1];
        }

        int minCost = -1;

        for (int color = 0; color < costs[index].length; color++) {
            if (color != prevColor) {
                int cost = costs[index][color] + minCostII(costs, index + 1, color, cache);
                if (minCost == -1 || cost < minCost) {
                    minCost = cost;
                }
            }
        }

        cache[index][prevColor + 1] = minCost;
        return minCost;
    }

}
