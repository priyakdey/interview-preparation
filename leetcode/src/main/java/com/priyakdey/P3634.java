package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class P3634 {

    public int minRemoval(int[] nums, int k) {
        int length = nums.length;
        if (length == 1) return 0;

        Arrays.sort(nums);

        int minCount = length;

        for (int start = 0; start < length - 1; start++) {
            long value = (long) nums[start] * k;
            int count = (start - 0) + findCount(nums, start + 1, value);
            minCount = Math.min(minCount, count);
        }

        return minCount;
    }

    /**
     * This function return the count of elements greater than
     * the given value.
     */
    private int findCount(int[] nums, int start, long value) {
        if (value > Integer.MAX_VALUE) return 0;

        int length = nums.length;
        int left = start, right = length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) nums[mid] > value) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index != -1 ? length - index : 0;
    }

}
