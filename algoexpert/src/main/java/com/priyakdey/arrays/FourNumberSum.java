package com.priyakdey.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class FourNumberSum {

    // Extension of 3 sum problem.
    // Sort the array, and then just extend the 3Sum problem with 3 pointers,
    // use the trick of skipping same numbers in the seq of each pointer, to
    // avoid duplicates.

    // TODO: check if we can O(n^2) solution instead of a cubic one!!

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        int length = array.length;
        Arrays.sort(array);

        List<Integer[]> quads = new ArrayList<>();

        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                int left = j + 1, right = length - 1;

                while (left < right) {
                    int sum = array[i] + array[j] + array[left] + array[right];
                    if (sum == targetSum) {
                        quads.add(new Integer[]{array[i], array[j], array[left], array[right]});
                        left++;
                        right--;
                    } else if (sum < targetSum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return quads;
    }

}
