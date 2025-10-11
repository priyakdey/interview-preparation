package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class HouseRobber {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);

        int nextMaxLoot = nums[length - 1];
        int adjacentMaxLoot = nums[length - 2];

        for (int i = length - 3; i >= 0; i--) {
            int currMaxLoot = nums[i] + nextMaxLoot;
            nextMaxLoot = Math.max(nextMaxLoot, adjacentMaxLoot);
            adjacentMaxLoot = currMaxLoot;
        }

        return Math.max(nextMaxLoot, adjacentMaxLoot);
    }

}
