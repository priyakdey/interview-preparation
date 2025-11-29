package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SingleNumber {

    // This is a classic BITWISE Magic.
    // a ^ a = 0, and a ^ 0 = 0.
    // So since all elements are in pairs, it will become 0
    // and only element left would be the one which is solo!!


    public int singleNumber(int[] nums) {
        int singleNumber = 0;
        for (int num : nums) {
            singleNumber ^= num;
        }

        return singleNumber;
    }

}
