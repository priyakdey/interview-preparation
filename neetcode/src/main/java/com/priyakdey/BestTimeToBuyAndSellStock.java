package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price > buyPrice) {
                maxProfit = Math.max(maxProfit, price - buyPrice);
            } else {
                buyPrice = price;
            }
        }

        return maxProfit;
    }

}
