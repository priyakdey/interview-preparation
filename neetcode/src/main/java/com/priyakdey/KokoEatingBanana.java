package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class KokoEatingBanana {

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int min = 1;

        int minPerHour = -1;

        while (min <= max) {
            int mid = min + (max - min)/2;
            int hours = totalTime(piles, mid);
            if (hours <= h) {
                minPerHour = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return minPerHour;
    }

    private int totalTime(int[] piles, int perHour) {
        int hour = 0;

        for (int pile : piles) {
            hour += (pile / perHour) + (pile % perHour == 0 ? 0 : 1);
        }

        return hour;
    }

}
