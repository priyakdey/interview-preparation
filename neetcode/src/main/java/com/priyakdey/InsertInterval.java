package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int intervalsLength = intervals.length;
        if (intervalsLength == 0) return new int[][]{{newInterval[0], newInterval[1]}};

        int tempLength = intervalsLength + 1;
        int[][] temp = new int[tempLength][2];

        int index = findInsertPosition(intervals, newInterval);
        if (index == -1) index = tempLength - 1;

        for (int i = 0; i < index; i++) {
            temp[i] = intervals[i];
        }

        temp[index] = newInterval;

        for (int i = index; i < intervalsLength; i++) {
            temp[i + 1] = intervals[i];
        }

        int start, end;
        int i = 1;
        int cursor = 0;

        while (i < tempLength) {
            int prevStart = temp[cursor][0];
            int prevEnd = temp[cursor][1];

            int currStart = temp[i][0];
            int currEnd = temp[i][1];

            if (currStart <= prevEnd) {
                start = prevStart;
                end = Math.max(currEnd, prevEnd);
            } else {
                start = currStart;
                end = currEnd;
                cursor++;
            }

            temp[cursor][0] = start;
            temp[cursor][1] = end;
            i++;
        }

        int[][] merged = new int[cursor + 1][2];
        System.arraycopy(temp, 0, merged, 0, cursor + 1);
        return merged;
    }

    private int findInsertPosition(int[][] intervals, int[] newInterval) {
        int left = 0, right = intervals.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (newInterval[0] <= intervals[mid][0]) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

}
