package com.priyakdey;

import java.util.Map;

/**
 * @author Priyak Dey
 */
public class P1056 {

    public boolean confusingNumber(int n) {
        Map<Integer, Integer> map = Map.of(0, 0, 1, 1, 6, 9, 8, 8, 9, 6);
        int temp = n;
        int reverse = 0;

        while (temp != 0) {
            int digit = temp % 10;
            if (!map.containsKey(digit)) return false;
            reverse = 10 * reverse + map.get(digit);
            temp /= 10;
        }

        return reverse == n;
    }

}
