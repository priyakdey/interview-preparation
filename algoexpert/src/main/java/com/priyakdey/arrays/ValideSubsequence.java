package com.priyakdey.arrays;

import java.util.List;

/**
 * @author Priyak Dey
 */
public class ValideSubsequence {

    // Take two pointers from start and start scanning.
    // If elements of both arrays at i, j is same, move both pointers.
    // At the end, if the pointer reaches the end of the sequence, it is a subsequence
    // of the other array.

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int arrayLength = array.size();
        int sequenceLength = sequence.size();

        if (sequenceLength > arrayLength) return false;

        int i = 0, j = 0;

        while (i < arrayLength && j < sequenceLength) {
            if (array.get(i).equals(sequence.get(j))) {
                j++;
            }
            i++;
        }

        return j == sequenceLength;
    }

}
