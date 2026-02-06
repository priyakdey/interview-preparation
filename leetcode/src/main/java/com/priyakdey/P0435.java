package com.priyakdey;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 */
public class P0435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] a) -> a[0])
                .thenComparingInt(a -> a[1]));

        int end = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {
                count++;
            }
        }

        return count;
    }

}
