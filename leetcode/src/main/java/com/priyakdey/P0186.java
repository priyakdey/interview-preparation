package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P0186 {

    public void reverseWords(char[] s) {
        int length = s.length;
        reverse(s, 0, length - 1);

        int start = 0;
        int curr = 0;

        while (curr < length) {
            while (curr < length && s[curr] != ' ') {
                curr++;
            }

            reverse(s, start, curr - 1);
            start = ++curr;
        }
    }

    private void reverse(char[] arr, int from, int to) {
        int left = from, right = to;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
}
