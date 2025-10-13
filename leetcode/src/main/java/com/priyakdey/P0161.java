package com.priyakdey;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class P0161 {

    public boolean isOneEditDistance(String s, String t) {
        if (Objects.equals(s, t)) return false;

        int sLength = s.length();
        int tLength = t.length();
        int diff = sLength - tLength;

        if (diff > 1 || diff < -1) return false;

        return switch (diff) {
            case 0 -> isOneEditDistanceWithSub(s, sLength, t, tLength);
            case 1 -> isOneEditDistanceWithAddition(s, sLength, t, tLength);
            case -1 -> isOneEditDistanceWithAddition(t, tLength, s, sLength);
            default -> throw new IllegalStateException("Unexpected value: " + diff);
        };
    }

    private boolean isOneEditDistanceWithAddition(String larger, int length1,
                                                  String smaller, int length2) {
        int i = 0, j = 0;

        while (i < length1 && j < length2) {
            if (larger.charAt(i) == smaller.charAt(j)) {
                j++;
            }
            i++;
        }

        return i == j || i == length1 && j == length2;
    }

    private boolean isOneEditDistanceWithSub(String s, int length1,
                                             String t, int length2) {
        int i = 0, j = 0;
        int k = 0;

        while (i < length1 && j < length2) {
            if (s.charAt(i) != t.charAt(j)) k++;
            i++;
            j++;
        }

        return k == 1;
    }


}
