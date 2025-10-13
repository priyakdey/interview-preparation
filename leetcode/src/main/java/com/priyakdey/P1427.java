package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P1427 {

    public String stringShift(String s, int[][] shift) {
        int finalShift = 0;

        for (int[] _s : shift) {
            int direction = _s[0];
            int amount = _s[1] * (direction == 0 ? -1 : 1);
            finalShift += amount;
        }

        if (finalShift == 0) return s;

        int k = Math.abs(finalShift) % s.length();
        if (finalShift < 0) {
            return  s.substring(k) + s.substring(0, k);
        }

        return s.substring(s.length() - k) + s.substring(0, s.length() - k);
    }

}
