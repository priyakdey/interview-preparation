package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class P0163 {

    public static List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0) return List.of(List.of(lower, upper));

        List<List<Integer>> missingRanges = new ArrayList<>();

        if (nums[0] != lower) {
            missingRanges.add(List.of(lower, nums[0] - 1));
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                missingRanges.add(List.of(nums[i - 1] + 1, nums[i] - 1));
            }
        }

        if (nums[nums.length - 1] != upper) {
            missingRanges.add(List.of(nums[nums.length - 1] + 1, upper));
        }

        return missingRanges;
    }

}
