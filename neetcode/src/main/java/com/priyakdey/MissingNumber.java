package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missingNumber = n * (n + 1) / 2;
        for (int num : nums) {
            missingNumber -= num;
        }

        return missingNumber;
    }

}
