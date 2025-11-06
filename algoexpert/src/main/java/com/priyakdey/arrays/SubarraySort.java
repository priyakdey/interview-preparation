package com.priyakdey.arrays;

/**
 * @author Priyak Dey
 */
public class SubarraySort {

    // Scan from left to right [1, length - 1], and keep track of currMax.
    // If any element is less than the currMax, the index needs a patch, record it.
    // Once scan done, the patch index should be the rightmost patch index.
    // Do the same scan from right to left [length - 2, 0], and consider same
    // logic with currMin, which should give the leftmost index to patch.
    // Then return the values and be happy!

    public static int[] subarraySort(int[] array) {
        int length = array.length;
        int left = -1, right = -1;

        int currMax = array[0];

        for (int i = 1; i < length; i++) {
            if (array[i] < currMax) {
                right = i;
            } else {
                currMax = array[i];
            }
        }

        int currMin = array[length - 1];

        for (int i = length - 2; i >= 0; i--) {
            if (array[i] > currMin) {
                left = i;
            } else {
                currMin = array[i];
            }
        }

        return new int[]{left, right};
    }

}
