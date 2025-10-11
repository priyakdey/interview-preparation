package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SumOfTwoIntegers {


    // NOTES: Full adder logic
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }

}
