package com.priyakdey.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class TwoNumberSum {

    // Use a Set to keep track of seen numbers in the array.
    // For each number, check if the compliment = target - number
    // is present in the set, if so return the values.

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> seen = new HashSet<>();

        for (int num : array) {
            int compliment = targetSum - num;
            if (seen.contains(compliment)) {
                return new int[]{compliment, num};
            }

            seen.add(num);
        }

        return new int[0];
    }

}
