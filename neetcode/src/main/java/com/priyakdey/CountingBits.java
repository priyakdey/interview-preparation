package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] bitCount = new int[n + 1];
        bitCount[0] = 0;
        if (n == 0) return bitCount;

        bitCount[1] = 1;
        if (n == 1) return bitCount;

        bitCount[2] = 1;
        if (n == 2) return bitCount;

        int prevPower = 2;
        int nextPower = 4;

        for (int i = 3; i <= n; i++) {
            if (i == nextPower) {
                bitCount[i] = 1;
                prevPower = nextPower;
                nextPower = nextPower << 1;
            } else {
                bitCount[i] = 1 + bitCount[i - prevPower];
            }
        }

        return bitCount;
    }

}
