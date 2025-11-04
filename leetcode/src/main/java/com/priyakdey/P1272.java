package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class P1272 {

    // Use binary search to find the first interval whose end exceeds the removal start and the
    // last interval whose start is before the removal end—these are the only intervals affected.
    // Add all intervals before the left index as-is, then trim or split the overlap between
    // left and right, and finally append the rest unchanged.
    // Handle the special case where both indices are equal by splitting a single interval
    // into up to two. Overall time is linear after the two binary searches,
    // so the full solution runs in O(n).

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        int left = findSmallestIntervalWithEndGtRemoveStart(intervals, toBeRemoved[0]);
        int right = findLargestIntervalWithStartLtRemoveEnd(intervals, toBeRemoved[1]);

        List<List<Integer>> result = new ArrayList<>();

        int cursor = 0;
        while (cursor < left) {
            result.add(List.of(intervals[cursor][0], intervals[cursor][1]));
            cursor++;
        }

        if (left != right) {

            if (intervals[left][0] < toBeRemoved[0]) {
                result.add(List.of(intervals[left][0], toBeRemoved[0]));
            }

            if (toBeRemoved[1] < intervals[right][1]) {
                result.add(List.of(toBeRemoved[1], intervals[right][1]));
            }
        } else {

            if (intervals[left][0] != toBeRemoved[0]) {
                result.add(List.of(intervals[left][0], toBeRemoved[0]));
            }

            if (toBeRemoved[1] != intervals[left][1]) {
                result.add(List.of(toBeRemoved[1], intervals[left][1]));
            }
        }

        cursor = right + 1;
        while (cursor < intervals.length) {
            result.add(List.of(intervals[cursor][0], intervals[cursor][1]));
            cursor++;
        }

        return result;
    }

    private int findLargestIntervalWithStartLtRemoveEnd(int[][] intervals, int removeEnd) {
        int index = intervals.length - 1;
        int left = 0, right = intervals.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int intervalStart = intervals[mid][0];
            if (intervalStart < removeEnd) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

    /**
     * Returns the leftmost index of the interval for which the end time is
     * greater than the start time.
     *
     * @param intervals   int[][]
     * @param removeStart int
     * @return leftmost index of the interval
     */
    private int findSmallestIntervalWithEndGtRemoveStart(int[][] intervals, int removeStart) {
        int index = 0;
        int left = 0, right = intervals.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int intervalEnd = intervals[mid][1];
            if (intervalEnd > removeStart) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

}
