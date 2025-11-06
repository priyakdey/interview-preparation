package com.priyakdey.arrays;

/**
 * @author Priyak Dey
 */
public class MinRewards {

    // Each student gets at least 1 reward.
    // Take an array of rewards, init with all values of 1.
    // Scan from left to right, if score[i] > score[i-1], reward of score[i] must be score[i -1] + 1
    // Scan from right to left, if score[i] > score[i-1], reward of score[i]
    // must be Math.max(existing reward[i], score[i -1] + 1)

    // Two passes handle both directions - take max of both constraints.
    // Sum final array for total rewards.

    public static int minRewards(int[] scores) {
        int length = scores.length;
        if (length < 3) return (2 * length) - 1;

        int[] arr1 = new int[length];

        arr1[0] = 1;
        for (int i = 1; i < length; i++) {
            if (scores[i] > scores[i - 1]) {
                arr1[i] = arr1[i - 1] + 1;
            } else {
                arr1[i] = 1;
            }
        }

        for (int i = length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                arr1[i] = Math.max(arr1[i], arr1[i + 1] + 1);
            }
        }

        int maxRewards = 0;
        for (int reward : arr1) {
            maxRewards += reward;
        }

        return maxRewards;
    }

}
