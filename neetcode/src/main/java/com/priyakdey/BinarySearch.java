package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int index = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

}
