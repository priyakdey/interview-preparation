package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P0266 {

    public boolean canPermutePalindrome(String s) {
        int[] freqTable = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freqTable[ch - 'a']++;
        }

        int left = 0;
        for (int freq : freqTable) {
            left += (freq & 1);
        }

        return left < 2;
    }


}
