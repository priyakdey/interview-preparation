package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class Subsets {

    // Use recursion and backtracking to generate the subsets.
    // If there are duplicates in the main array, sort it,
    // so that we can skip over elements if nums[i] == nums[i - 1]

    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        int subsetCount = length * (length + 1) / 2;

        List<Integer> subset = new ArrayList<>(length);
        List<List<Integer>> subsets = new ArrayList<>(subsetCount);
        subsets.add(List.of());

        generateSubsets(nums, 0, subset, subsets);
        return subsets;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> subset,
                                 List<List<Integer>> subsets) {
        if (index == nums.length) return;
        generateSubsets(nums, index + 1, subset, subsets);

        subset.add(nums[index]);
        subsets.add(new ArrayList<>(subset));
        generateSubsets(nums, index + 1, subset, subsets);
        subset.removeLast();
    }
}
