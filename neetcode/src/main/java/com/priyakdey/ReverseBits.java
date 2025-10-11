package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ReverseBits {

    public int reverseBits(int n) {
        long reverse = 0;

        for (int i = 0; i < 32; i++) {
            reverse = reverse | (((n >>> i) & 1) << (31 - i));
        }

        return (int) reverse;
    }

}
