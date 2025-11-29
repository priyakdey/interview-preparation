package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P3512 {

    // https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/?envType=daily-question&envId=2025-11-29

    // Since we can only perform -1 as an operation, we can simply take mod and reduce to 0.
    // If +/- 1 both where options, we would have to do mod, and see, if we can reach 0 or k
    // with min operations!!

    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum % k;
    }

}
