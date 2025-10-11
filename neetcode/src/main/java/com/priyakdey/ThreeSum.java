package com.priyakdey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if  (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j =  i + 1,  k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return triplets;
    }

}
