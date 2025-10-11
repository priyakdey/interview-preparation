package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int length = s.length();
        int count = 0;
        int left, right;

        for (int i = 0; i < length; i++) {
            // generate odd length palindromes
            count++;
            left = i - 1;
            right = i + 1;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }

            // generate even length palindromes
            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                left = i - 1;
                right = i + 2;
                while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    count++;
                }
            }
        }

        return count;
    }

}
