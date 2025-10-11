package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int length = nums.length;
        int left = 0,  right = length - 1;
        int minElement = nums[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[length - 1]) {
                minElement = Math.min(minElement, nums[mid]);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minElement;
    }

}
