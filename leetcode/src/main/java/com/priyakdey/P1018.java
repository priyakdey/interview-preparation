package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class P1018 {

    // https://leetcode.com/problems/binary-prefix-divisible-by-5/submissions/1838732304/?envType=daily-question&envId=2025-11-24

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>(nums.length);

        int n = 0;

        for (int num : nums) {
            n = ((n << 1) + num) % 10;
            result.add(n % 5 == 0);
        }

        return result;
    }

}
