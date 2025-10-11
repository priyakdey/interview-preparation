package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int maxTill = nums[0];
        int minTill = nums[0];
        int maxOverall = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxTill = 0;
                minTill = 0;
            } else {
                int max = max(maxTill * nums[i], minTill * nums[i], nums[i]); 
                int min = min(maxTill * nums[i], minTill * nums[i], nums[i]);
                maxTill = max;
                minTill = min;
            }

            maxOverall = max(maxTill, maxOverall);
        }

        return maxOverall;
    }

    private int max(int... nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
    
    private int min(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }

}
