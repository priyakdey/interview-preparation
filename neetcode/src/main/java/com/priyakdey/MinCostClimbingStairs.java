package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MinCostClimbingStairs {

    // Let us consider an array with two elements - so min(arr[0], arr[1])
    // is the answer. Since from -1 I can jump to 0 or 1.
    // So let us extrapolate this idea. We will continue from length - 3.
    // The min cost of jumping to top from
    // length - 3 = cost[l - 3] + min(minCost[l - 2], minCost[l - 1]).
    // Extrapolating this, we can find the min cost.

    // For space efficiency, we just need state of minCost at i + 1 and i + 2.

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int nextMinCost = cost[length - 2];
        int nextToNextMinCost = cost[length - 1];


        for (int i = length - 3; i >= 0; i--) {
            int minCost = cost[i] + Math.min(nextMinCost, nextToNextMinCost);
            nextToNextMinCost = nextMinCost;
            nextMinCost = minCost;
        }

        return Math.min(nextMinCost, nextToNextMinCost);
    }

}
