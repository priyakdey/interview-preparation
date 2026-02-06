package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P3783 {

    // https://leetcode.com/problems/mirror-distance-of-an-integer/description/

    // NOTE: we convert to long to avoid overflow when working with int32.

    public int mirrorDistance(int n) {
        return (int) Math.abs((long) n - reverseNum(n));
    }

    private long reverseNum(long num) {
        long reverse = 0;

        while (num > 0) {
            reverse = (reverse * 10) + (num % 10);
            num = num / 10;
        }

        return reverse;
    }

}
