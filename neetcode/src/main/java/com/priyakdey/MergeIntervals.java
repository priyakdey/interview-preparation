package com.priyakdey;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[0])
                .thenComparing((int[] interval) -> interval[1]));

        int length =  intervals.length;
        int[][] merged = new int[length][2];

        merged[0] = intervals[0];
        int cursor = 0;
        for (int i = 1; i < length; i++) {
            int lastStartTime = merged[cursor][0];
            int lastEndTime = merged[cursor][1];

            int currentStartTime = intervals[i][0];
            int currentEndTime = intervals[i][1];

            int start, end;

            if (currentStartTime <= lastEndTime) {
                start = Math.min(lastStartTime, currentStartTime);
                end = Math.max(lastEndTime, currentEndTime);
            } else {
                start = currentStartTime;
                end = currentEndTime;
                cursor++;
            }

            merged[cursor][0] = start;
            merged[cursor][1] = end;
        }

        int[][] result = new int[cursor + 1][2];
        for (int i = 0; i <= cursor; i++) {
            result[i][0] = merged[i][0];
            result[i][1] = merged[i][1];
        }

        return result;
    }

}
