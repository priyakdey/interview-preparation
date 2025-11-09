package com.priyakdey.arrays;

/**
 * @author Priyak Dey
 */
public class MonotonicArray {

    // Take two flags.
    // DON'T TAKE NEG_NEG FLAGS ELSE YOU WANT YOUR BRAINS FRIED..
    // One flag determines if values are eq or increasing (non-decreasing)
    // Second flag determines if values are eq or decreasing (non-increasing)
    // Set both flags to true.

    // Iterate from 1st element and compare arr[i] and arr[i - 1].
    // If arr[i] < arr[i - 1]: set first flag to false.
    // If arr[i] > arr[i - 1]: set second flag to false.
    // If both flags are false, return false, else can return true.

    public static boolean isMonotonic(int[] array) {
        int length = array.length;
        if (length < 3) return true;

        boolean isIncreasingOrEq = true;     // flag to determine if a[i] >= a[i - 1]
        boolean isDecreasingOrEq = true;     // flag to determine if a[i] <= a[i - 1]

        for (int i = 1; i < length; i++) {
            if (array[i] < array[i - 1]) {
                isIncreasingOrEq = false;
            }

            if (array[i] > array[i - 1]) {
                isDecreasingOrEq = false;
            }
        }

        return isIncreasingOrEq || isDecreasingOrEq;
    }

}
