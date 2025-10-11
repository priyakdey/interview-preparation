package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        Integer[][] cache = new Integer[coins.length + 1][amount + 1];
        return coinChange(coins, 0, amount, cache);
    }

    private int coinChange(int[] coins, int index, int amount, Integer[][] cache) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        if (cache[index][amount] != null) return cache[index][amount];

        int count = -1;

        for (int i = index; i < coins.length; i++) {
            int _count = coinChange(coins, i, amount - coins[i], cache);
            if (_count > -1) {
                _count = 1 + _count;
                count = count  != -1 ? Math.min(count, _count) : _count;
            }
        }

        cache[index][amount] = count;
        return count;
    }

}
