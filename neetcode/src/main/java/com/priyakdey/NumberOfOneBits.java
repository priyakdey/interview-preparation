package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class NumberOfOneBits {

    public int hammingWeight(int n) {
        int setBits = 0;

        for (int i = 0; i < 32; i++) {
            setBits += ((n >>> i) & 1);
        }

        return setBits;
    }

}
