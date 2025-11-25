package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int value = Math.abs(nums[i]);
            if (nums[value] < 0) return value;
            nums[value] *= -1;
        }

        return -1;
    }

}
