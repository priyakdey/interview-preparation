package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P1180 {

    public int countLetters(String s) {
        int length = s.length();
        int curr = 0;
        int count = 0;

        while (curr < length) {
            int start = curr;
            while (curr < length && s.charAt(curr) == s.charAt(start)) {
                curr++;
            }
            int n = curr - start;
            count += n * (n + 1) / 2;
        }

        return count;
    }

}
