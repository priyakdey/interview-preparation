package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P1134 {

    public boolean isArmstrong(int n) {
        int k = findLength(n);

        int temp = 0;
        int x = n;

        while (x != 0) {
            int digit = x % 10;
            temp += (int) Math.pow(digit, k);
            x /= 10;
        }

        return temp == n;
    }

    private int findLength(int n) {
        int length = 0;
        while (n != 0) {
            length++;
            n /= 10;
        }

        return length;
    }

}
