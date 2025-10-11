package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int maxLength = 0;
        Deque<Integer> stack = new ArrayDeque<>(nums.length);

        for (int num : nums) {
            while (!stack.isEmpty() && num <= stack.peek()) {
                stack.pop();
            }

            stack.push(num);
            maxLength = Math.max(maxLength, stack.size());
        }

        return maxLength;
    }

}
