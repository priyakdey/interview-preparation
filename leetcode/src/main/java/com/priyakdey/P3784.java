package com.priyakdey;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class P3784 {

    // https://leetcode.com/problems/minimum-deletion-cost-to-make-all-characters-equal/description/

    public long minCost(String s, int[] cost) {
        Map<Character, Long> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            final int _cost = cost[i];
            map.compute(c, (k, v) -> v == null ? _cost : v + _cost);
        }

        Set<Character> uniqChars = map.keySet();
        long minCost = Long.MAX_VALUE;

        for (char c : uniqChars) {
            long totalCost = 0;
            for (char ch : uniqChars) {
                if (ch != c) {
                    totalCost += map.get(ch);
                }
            }

            minCost = Math.min(minCost, totalCost);
        }

        return minCost;
    }

}
