package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int left = -1, right = -1;
        int maxLength = 0;

        int l, r, length;

        for (int i = 0; i < s.length(); i++) {
            // odd length palindrome
            l = i - 1;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            length = (r - 1) - (l + 1) + 1;
            if (length > maxLength) {
                left = l + 1;
                right = r;
                maxLength = length;
            }

            // even length palindrome
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                l = i - 1;
                r = i + 2;
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }

                length = (r - 1) - (l + 1) + 1;
                if (length > maxLength) {
                    left = l + 1;
                    right = r;
                    maxLength = length;
                }
            }
        }

        return s.substring(left, right);
    }

}
