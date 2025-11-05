package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P0443 {

    public int compress(char[] chars) {
        int i = 0, j = 0;

        while (i < chars.length) {
            char ch = chars[i];
            int start = i;
            while (i < chars.length  && chars[i] == ch) {
                i++;
            }

            int streak = i - start;
            chars[j] = ch;
            j++;
            if (streak == 1)  {
                continue;
            }

            // insert the length
            start = j;      // start of the length
            while (streak > 0) {
                int val = streak % 10;
                chars[j++] = (char) (val + 48);
                streak /= 10;
            }

            // reverse from [start, j)
            int k = j - 1;
            while (start < k) {
                char temp = chars[start];
                chars[start] = chars[k];
                chars[k] = temp;
                start++;
                k--;
            }
        }

        return j;
    }

}
