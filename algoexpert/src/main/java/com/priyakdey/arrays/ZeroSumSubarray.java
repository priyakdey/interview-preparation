package com.priyakdey.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class ZeroSumSubarray {

    // Scan from left to right and find the curr running sum.
    // If currSum == 0 or have previously seen the same currSum, there
    // is a subarray with sum 0.
    // For faster lookup of currSum, we can use a Set.


    public boolean zeroSumSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int currSum = 0;

        for (int num : nums) {
            currSum += num;
            if (currSum == 0 || set.contains(currSum)) return true;
            set.add(currSum);
        }

        return false;
    }

}
