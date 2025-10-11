package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);

            if (!isAlnum(c1)) {
                left++;
                continue;
            }

            if (!isAlnum(c2)) {
                right--;
                continue;
            }

            if (!isSame(c1, c2)) return false;
            left++;
            right--;
        }

        return true;
    }

    private boolean isAlnum(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }

    private boolean isSame(char c1, char c2) {
        if (c1 >= 'A' && c1 <= 'Z') {
            c1 = (char) (c1 ^ 32);
        }
        
        if (c2 >= 'A' && c2 <= 'Z') {
            c2 = (char) (c2 ^ 32);
        }

        return c1 == c2;
    }

}
