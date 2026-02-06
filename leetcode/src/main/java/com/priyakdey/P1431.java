package com.priyakdey;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Priyak Dey
 */
public class P1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];

        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        List<Boolean> result = new ArrayList<>(candies.length);

        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }

        return result;
    }

}
