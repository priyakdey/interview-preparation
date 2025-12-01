package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if ((totalSum & 1) == 1) return false;

        int target = totalSum / 2;
        Boolean[][] cache = new Boolean[nums.length + 1][target + 1];
        return canPartition(nums, 0, 0, target, cache);

        // TODO: Solve this my friend !!!

        // boolean[][] cache = new boolean[nums.length + 1][target + 1];
        //
        // for (int col = 0; col <= target; col++) {
        //     cache[nums.length][col] = false;
        // }
        //
        // for (int row = 0; row <= nums.length; row++) {
        //     cache[row][target] = true;
        // }
        //
        // for (int row = nums.length - 1; row >= 0; row--) {
        //     for (int col = target - 1; col >= 0; col--) {
        //         cache[row][col] = cache[row + 1][col] ||
        //                 cache[row + 1][col + nums[row]];
        //     }
        // }
        //
        // return cache[0][0];
    }

    private boolean canPartition(int[] nums, int index, int runningSum,
                                 int target, Boolean[][] cache) {
        if (index == nums.length) return false;
        if (runningSum == target) return true;

        if (cache[index][runningSum] != null) {
            return cache[index][runningSum];
        }

        boolean can = canPartition(nums, index + 1, runningSum, target, cache)
                || canPartition(nums, index + 1,
                runningSum + nums[index], target, cache);
        cache[index][runningSum] = can;

        dump(cache);

        return can;
    }

    private void dump(Boolean[][] cache) {
        for (Boolean[] c : cache) {
            System.out.println(Arrays.toString(c));
        }
    }

}
