package com.priyakdey;

import java.util.Comparator;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class MeetingRooms {

    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()) return true;

        intervals.sort(Comparator.comparingInt((Interval i) -> i.start)
                .thenComparingInt((Interval i) -> i.end));

        int prevEnd = intervals.getFirst().end;

        for (int i = 1; i < intervals.size(); i++) {
            int currStart = intervals.get(i).start;
            int currEnd = intervals.get(i).end;
            if (currStart < prevEnd) {
                return false;
            }
            prevEnd = currEnd;
        }

        return true;
    }

    public class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
