package com.priyakdey.arrays;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class NonConstructibleChange {

    // Sort the array first. If first element != 1, we cannot make 1.
    // Else start with currSum = 1 and scan from 1st element.
    // If at any point, the currElement > currSum + 1, it means, we cannot make
    // currSum + 1.

    public int nonConstructibleChange(int[] coins) {
        int length = coins.length;
        if (length == 0) return 1;

        Arrays.sort(coins);

        if (coins[0] != 1) return 1;

        int currSum = 1;
        for (int i = 1; i < length; i++) {
            int coin = coins[i];
            if (coin > currSum + 1) break;
            currSum += coin;
        }

        return currSum + 1;
    }

}
