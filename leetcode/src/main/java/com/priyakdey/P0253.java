package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class P0253 {

    public int minMeetingRooms(int[][] intervals) {
        int length = intervals.length;
        int[] startTimes = new int[length];
        int[] endTimes = new int[length];

        for (int i = 0; i < length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int total = 1;
        int empty = 0;

        int i = 1, j = 0;

        while (i < startTimes.length) {
            if (startTimes[i] < endTimes[j]) {
                if (empty > 0) {
                    empty--;
                } else {
                    total++;
                }
                i++;
            } else {
                empty++;
                j++;
            }
        }

        return total;
    }

}
