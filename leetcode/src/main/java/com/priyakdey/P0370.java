package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P0370 {

    // https://leetcode.com/problems/range-addition/description/

    public int[] getModifiedArray(int length, int[][] updates) {
        return getModifiedArraySimulate(length, updates);
    }

    // simulate the updates like a set of instructions for the
    // VM - slow
    private int[] getModifiedArraySimulate(int length, int[][] updates) {
        int[] arr = new int[length];

        for (int[] update : updates) {
            for (int i = update[0]; i <= update[1]; i++) {
                arr[i] += update[2];
            }
        }

        return arr;
    }


}
