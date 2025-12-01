package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        List<Integer> buffer = new ArrayList<>(nums.length);

        for (int num : nums) {
            if (buffer.isEmpty() || num > buffer.getLast()) {
                buffer.add(num);
            } else if (num == buffer.getLast()) {
                continue;
            } else {
                int index = findFirstInsertPosition(buffer, num);
                buffer.add(index, num);
                buffer = buffer.subList(0, index + 1);
            }
        }

        return buffer.size();
    }

    private int findFirstInsertPosition(List<Integer> arr, int target) {
        int left = 0, right = arr.size() - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) >= target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

}
