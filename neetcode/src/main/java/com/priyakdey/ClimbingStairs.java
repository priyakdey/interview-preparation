package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ClimbingStairs {


    // NOTES: fibonacci series
    public int climbStairs(int n) {
        Integer[] cache = new Integer[n + 1];
        return climbStairs(n, cache);
    }

    private int climbStairs(int n, Integer[] cache) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        if (cache[n] != null) return cache[n];

        cache[n] = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
        return cache[n];
    }

}
