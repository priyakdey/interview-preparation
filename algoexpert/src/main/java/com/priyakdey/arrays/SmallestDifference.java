package com.priyakdey.arrays;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class SmallestDifference {

    // Sort both arrays.
    // Two pointers from the start of each array, find abs diff and calculate the
    // min abs diff and capture the elements.
    // If arr1[i] <= arr2[j], move the i pointer forward, else move the j pointer forward.

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int i = 0, j = 0;
        int smallestDiff = Integer.MAX_VALUE;
        int[] elements = new int[] {-1, -1};

        while (i < arrayOne.length && j < arrayTwo.length) {
            int diff = Math.abs(arrayOne[i] - arrayTwo[j]);
            if (diff <= smallestDiff) {
                smallestDiff = diff;
                elements[0] = arrayOne[i];
                elements[1] = arrayTwo[j];
            }

            if (arrayOne[i] <= arrayTwo[j]) {
                i++;
            } else {
                j++;
            }
        }

        return elements;
    }

}
