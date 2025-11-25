package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P3234 {

    public int numberOfSubstrings(String s) {
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            int zero = 0;
            int one = 0;
            for (int j = i; j < length; j++) {
                char ch = s.charAt(j);
                if (ch == '0') {
                    zero++;
                } else {
                    one++;
                }

                if (one >= zero * zero) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        P3234 p3234 = new P3234();
        System.out.println(p3234.numberOfSubstrings("00011"));
    }

}
