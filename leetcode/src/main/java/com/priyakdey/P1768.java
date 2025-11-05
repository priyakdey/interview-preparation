package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P1768 {

    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder sb = new StringBuilder(len1 + len2);

        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        if (i < len1) sb.append(word1.substring(i));
        if (j < len2) sb.append(word2.substring(j));
        
        return sb.toString();
    }

}
