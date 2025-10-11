package com.priyakdey;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> notProcessed = new HashSet<>();
        for (int num : nums) {
            notProcessed.add(num);
        }

        int maxRange = 0;

        for (int num : nums) {
            if (!notProcessed.contains(num)) continue;

            int left = num;
            while (notProcessed.contains(left)) {
                notProcessed.remove(left);
                left--;
            }

            int right = num + 1;
            while (notProcessed.contains(right)) {
                notProcessed.remove(right);
                right++;
            }

            int range = (right - 1) - (left + 1) + 1;
            maxRange = Math.max(maxRange, range);
        }

        return maxRange;
    }

}
