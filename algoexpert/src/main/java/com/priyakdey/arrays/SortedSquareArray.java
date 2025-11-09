package com.priyakdey.arrays;

/**
 * @author Priyak Dey
 */
public class SortedSquareArray {

    // Since there can be negative numbers which when squared can become more than
    // square of a positive number, we take the approach of filling the result array
    // from the back.

    // Take two pointers left and right, and square elements at those pointers.
    // If sq(arr[left]) >= sq(arr[right]), push that element to the back, and move
    // the pointers accordingly.

    public int[] sortedSquaredArray(int[] array) {
        int length = array.length;
        int[] squares = new int[length];
        int left = 0, right = length - 1;
        int k = length - 1;

        while (left <= right) {
            int x = array[left] * array[left];
            int y =  array[right] * array[right];
            if (x >= y) {
                squares[k--] = x;
                left++;
            } else {
                squares[k--] = y;
                right--;
            }
        }

        return squares;
    }

}
