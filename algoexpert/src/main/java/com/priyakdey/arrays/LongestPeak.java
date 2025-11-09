package com.priyakdey.arrays;

/**
 * @author Priyak Dey
 */
public class LongestPeak {

    // TODO: DO NOT LIKE THIS NOW, VISIT LATER

    public static int longestPeak(int[] array) {
        int length = array.length;
        if (length < 3) return 0;

        int maxPeak = 0;
        int curr = 1;
        while (curr < length) {
            int start = curr;

            // try and climb the uphill
            while (curr < length && array[curr] > array[curr - 1]) {
                curr++;
            }

            if (curr == length) break;
            if (array[curr] == array[curr - 1]) {
                curr++;
                continue;
            }

            // try and go downhill
            while (curr < length && array[curr] < array[curr - 1]) {
                curr++;
            }

            // capture the length of the peak
            maxPeak = Math.max(maxPeak, curr - start + 1);

            if (curr == length) break;
            if (array[curr] == array[curr - 1]) {
                curr++;
            }
        }

        return maxPeak;
    }

    static void main() {
        System.out.println(longestPeak(new int[]{5, 4, 3, 2, 1, 2, 1}));
    }

}
