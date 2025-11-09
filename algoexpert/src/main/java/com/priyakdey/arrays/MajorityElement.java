package com.priyakdey.arrays;

/**
 * @author Priyak Dey
 */
public class MajorityElement {

    // Majority Element is based on the Boyer-Moore Algorithm:
    // https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm

    // Assign the first number as the majority element, keep bias a 1.
    // Scan the array, if element is same, increment bias, else decrement.
    // If bias == 0, reassign the majority element to the current element and reset bias to 1.

    public int majorityElement(int[] array) {
        int length = array.length;
        if (length == 0) return -1;

        int majorityElement = array[0];
        int bias = 1;

        for (int i = 1; i < length; i++) {
            if (array[i] == majorityElement) {
                bias++;
            } else {
                bias--;
            }

            if (bias == 0) {
                majorityElement = array[i];
                bias = 1;
            }
        }

        return majorityElement;
    }

}
