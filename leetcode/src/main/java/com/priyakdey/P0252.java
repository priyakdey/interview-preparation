package com.priyakdey;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 */
public class P0252 {

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length < 2) return true;

        Arrays.sort(intervals, Comparator.comparing((int[] arr) -> arr[0])
                .thenComparing((int[] arr) -> arr[1]));

        int endTime = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < endTime) return false;
            endTime = intervals[i][1];
        }

        return true;
    }

}
