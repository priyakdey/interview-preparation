package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        if (length == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));

        // loot the last house
        int nextMaxLoot = nums[length - 1];
        int adjacentMaxLoot = nums[length - 2];

        for (int i = length - 3; i >= 1; i--) {
            int currMaxLoot = nums[i] + nextMaxLoot;
            nextMaxLoot = Math.max(nextMaxLoot, adjacentMaxLoot);
            adjacentMaxLoot = currMaxLoot;
        }

        int maxLoot = Math.max(nextMaxLoot, adjacentMaxLoot);

        // loot the first house
        nextMaxLoot = nums[length - 2];
        adjacentMaxLoot = nums[length - 3];

        for (int i = length - 4; i >= 0; i--) {
            int currMaxLoot = nums[i] + nextMaxLoot;
            nextMaxLoot = Math.max(nextMaxLoot, adjacentMaxLoot);
            adjacentMaxLoot = currMaxLoot;
        }

        maxLoot = Math.max(maxLoot, Math.max(nextMaxLoot, adjacentMaxLoot));
        return maxLoot;
    }
}
