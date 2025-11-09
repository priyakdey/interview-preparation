package com.priyakdey.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 */
public class MergeOverlappingIntervals {

    // Sort the intervals according to start time and end times.
    // Push the first interval in the merged intervals array.
    // Now, iterate from the 1st interval intervals[1], and capture currTimes and
    // prev Times - merged[cursor].

    // If currStart <= prevEnd, we have overlap, so just set start and end.
    // Else, we have a new interval, we do increase the cursor. Since this is static array,
    // we can move the cursor, if was List, we needed to added one Node/Slot to it!

    // Then just push the start, end to the merged[cursor].
    // Now trim down the merged array.

    // TODO: You have done this a billion times, and good with english too.
    // You can surely write a little better notes than this...! TRY !!

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        int length = intervals.length;
        if (length < 2) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt((int[] a) -> a[1]));

        int[][] merged = new int[length][2];
        int cursor = 0;
        merged[cursor] = intervals[0];

        int start, end;

        for (int i = 1; i < length; i++) {
            int prevStart = merged[cursor][0];
            int prevEnd   = merged[cursor][1];

            int currStart = intervals[i][0];
            int currEnd   = intervals[i][1];

            if (currStart <= prevEnd) {
                start = prevStart;
                end = Math.max(prevEnd, currEnd);
            } else {
                start = currStart;
                end = currEnd;
                cursor++;
            }

            merged[cursor][0] = start;
            merged[cursor][1] = end;
        }

        System.out.println(Arrays.deepToString(merged));

        // trim down merged to cursor + 1 length
        int[][] results = new int[cursor + 1][2];
        for (int i = 0; i <= cursor; i++) {
            System.arraycopy(merged[i], 0, results[i], 0, 2);
        }

        return results;
    }

}
