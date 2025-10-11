package com.priyakdey;

import java.util.Arrays;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class MeetingRoomsII {

    public int minMeetingRooms(List<Interval> intervals) {
        int length = intervals.size();
        if (length < 2) return length;
        int[] start = new int[length];
        int[] end = new int[length];

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            start[i] = interval.start;
            end[i] = interval.end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 1;
        int empty = 0;

        int i = 1, j = 0;

        while (i < length) {
            if (start[i] < end[j]) {
                if (empty > 0) {
                    empty--;
                } else {
                    rooms++;
                }
                i++;
            } else {
                j++;
                empty++;
            }
        }

        return rooms;
    }

    public class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
