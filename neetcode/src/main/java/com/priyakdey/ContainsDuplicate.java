package com.priyakdey;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class ContainsDuplicate {

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();

        for (int num : nums) {
            if (!visited.add(num)) return true;
        }

        return false;
    }

}
