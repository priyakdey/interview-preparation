package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class P1590 {

    // https://leetcode.com/problems/make-sum-divisible-by-p/description

    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % p == 0) return 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            
        }


        return minLength != nums.length ? minLength : -1;
    }


}
