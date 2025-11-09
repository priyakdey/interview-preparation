package com.priyakdey.arrays;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class SweetAndSavory {

    // Sort the given array.
    // If no positive or negative numbers, return [0,0]
    // Scan linear in the range of negatives, and for each negative sweet dish
    // do a binary search to find the largest positive number which adds to the
    // greatest number less than or equal to the target.

    public int[] sweetAndSavory(int[] dishes, int target) {
        int length = dishes.length;
        Arrays.sort(dishes);

        int positiveIndex = -1;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dishes[mid] > 0) {
                positiveIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (positiveIndex < 1) return new int[]{0, 0};

        int[] result = new int[2];
        for (int i = 0; i < positiveIndex; i++) {
            left = positiveIndex;
            right = length - 1;

            int index = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (dishes[i] + dishes[mid] <= target) {
                    index = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (index == -1) continue;

            if (result[0] == 0 && result[1] == 0 ||
                    dishes[i] + dishes[index] > result[0] + result[1]) {
                result[0] = dishes[i];
                result[1] = dishes[index];
            }
        }

        return result;
    }

    static void main() {
        var a = new SweetAndSavory();
        System.out.println(Arrays.toString(a.sweetAndSavory(new int[]{-5, 10}, 4)));
    }

}
