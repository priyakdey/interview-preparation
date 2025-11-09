package com.priyakdey.arrays;

/**
 * @author Priyak Dey
 */
public class BestSeat {

    // This problem boils down to the question -
    // leftmost largest range of 0, and the mid position for it.

    public static int bestSeat(int[] seats) {
        int length = seats.length;
        if (length < 2) return -1;

        int longestRange = 0;
        int left = -1, right = -1;

        int curr = 0;
        while (curr < length) {
            if (seats[curr] == 0) {
                int start = curr;
                while (curr < length && seats[curr] == 0) {
                    curr++;
                }
                int range = curr - start;
                if (range > longestRange) {
                    longestRange = range;
                    left = start;
                    right = curr - 1;
                }
            }
            curr++;
        }

        return (left + right) / 2;
    }

    static void main() {
        System.out.println(bestSeat(new int[]{1, 0, 1, 0, 0, 0, 1}));
    }

}
