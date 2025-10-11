package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(nums, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void combinationSum(int[] nums, int index, int target, List<Integer> buf,
                                List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(buf));
            return;
        }


        for (int i = index; i < nums.length; i++) {
            buf.add(nums[i]);
            combinationSum(nums, i, target - nums[i], buf, res);
            buf.removeLast();
        }
    }

}
