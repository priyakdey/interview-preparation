package com.priyakdey;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 */
public class MinimumIntervalToIncludeEachQuery {

    public int[] minInterval(int[][] intervals, int[] queries) {
        int length = queries.length;
        int[][] values =  new int[length][2];

        for (int i = 0; i < length; i++) {
            values[i][0] = queries[i];
            values[i][1] = i;
        }

        Arrays.sort(values, Comparator.comparingInt(arr -> arr[0]));

        int[] result = new int[length];

        for (int[] interval : intervals) {
            int left = interval[0], right = interval[1];
            int duration = right - left + 1;
            int leftBound  = findIndexGte(values, left);
            int rightBound = findIndexLte(values, right);

            if (leftBound != -1 && rightBound != -1) {
                for (int i = leftBound; i <= rightBound; i++) {
                    int value = values[i][0];
                    int index = values[i][1];
                    if (result[index] == -1 || duration < result[index]) {
                        result[index] = duration;
                    }
                }
            }
        }

        return result;
    }

    private int findIndexLte(int[][] arr, int target) {
        int index = -1;
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid][0] <= target) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

    private int findIndexGte(int[][] arr, int target) {
        int index = -1;
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid][0] >= target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

}
