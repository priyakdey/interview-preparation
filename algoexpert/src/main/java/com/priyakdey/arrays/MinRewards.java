package com.priyakdey.arrays;

/**
 * @author Priyak Dey
 */
public class MinRewards {

    public static int minRewards(int[] scores) {
        int length = scores.length;
        if (length < 3 ) return (2 * length) - 1;

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
