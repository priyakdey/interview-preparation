package com.priyakdey.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class ThreeNumberSum {

    // Sort the array and then linear scan each element and a two pointer
    // scan for the rest of the array to find the triplets.

    // Since problem statement says distinct, we do not skip,
    // else we can always look back at i-1, or j - 1, and skip
    // if elements are same to avoid duplicates.

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        int length = array.length;

        List<Integer[]> triplets = new ArrayList<Integer[]>();

        Arrays.sort(array);

        for (int i = 0; i < length - 2; i++) {
            int j = i + 1, k = length - 1;

            while (j < k) {
                int sum = array[i] + array[j] + array[k];
                if (sum == targetSum) {
                    triplets.add(new Integer[]{array[i], array[j], array[k]});
                    j++;
                    k--;
                } else if (sum > targetSum) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return triplets;
    }

}
