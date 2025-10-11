package com.priyakdey;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] arr) -> arr[0])
                .thenComparingInt(arr -> arr[1]));

        int prevEnd =  intervals[0][1];

        int remove = 0;

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd   = intervals[i][1];
            if (currStart < prevEnd) {
                remove++;
                prevEnd = Math.min(prevEnd, currEnd);
            } else {
                prevEnd = currEnd;
            }
        }

        return remove;
    }

}
