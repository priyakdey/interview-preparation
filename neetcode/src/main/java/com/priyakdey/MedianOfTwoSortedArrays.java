package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MedianOfTwoSortedArrays {

    // NOTE: We cheat for now, we need to think how to do this using BS

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int length = length1 + length2;
        int[] arr = new int[length];

        int i = length1 - 1, j = length2 - 1;
        int k = length - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                arr[k--] = nums1[i--];
            } else {
                arr[k--] = nums2[j--];
            }
        }

        while (i >= 0) {
            arr[k--] = nums1[i--];
        }

        while (j >= 0) {
            arr[k--] = nums2[j--];
        }

        int mid = length / 2;
        if ((length & 1) == 1) {
            return arr[mid];
        } else {
            return (arr[mid - 1] + arr[mid]) / 2.0;
        }
    }

}
