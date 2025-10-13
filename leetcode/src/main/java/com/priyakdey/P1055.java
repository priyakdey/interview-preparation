package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P1055 {

    public int shortestWay(String source, String target) {
        int i = 0, k = 0;

        while (i < target.length()) {
            int j = 0;
            int prevI = i;
            while (j < source.length() && i < target.length()) {
                if (source.charAt(j) == target.charAt(i)) {
                    i++;
                }
                j++;
            }

            if (i == prevI) return -1;
            k++;
        }

        return k;
    }

}
