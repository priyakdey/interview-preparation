package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;

        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }

            if (nums[mid] > nums[length - 1]) {
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    if (target <= nums[length - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            } else {
                if (target > nums[mid]) {
                    if (target <= nums[length - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    right = mid - 1;
                }
            }
        }

        return index;
    }

}
