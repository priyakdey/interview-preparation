package com.priyakdey.arrays;

/**
 * @author Priyak Dey
 */
public class FirstDuplicateValue {

    // Since elements are within [1, n] and length = n,
    // we can use the indices within the array to denote
    // if we have seen the element before.
    // Since we have [1, n] for index, we need to offset by 1.

    // Scan through the elements, take the abs value = abs(arr[i]).
    // Index = arr[i] - 1. If arra[arr[i] - 1] == -ve, means we have
    // visited this element before, we can return element = abs(arr[i]).
    // Else, make the element -ve and move forward.

    public int firstDuplicateValue(int[] array) {
        int length = array.length;
        if (length < 2) return -1;

        for (int i = 0; i < length; i++) {
            int element = Math.abs(array[i]);
            int index = element - 1;
            if (array[index] < 0) return element;
            array[index] *= -1;
        }

        return -1;
    }

}
