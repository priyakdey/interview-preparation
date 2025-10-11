package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ContainerWithMostWater {

    public int maxArea(int[] heights) {
        int maxArea = 0;
        int length = heights.length;
        int left = 0, right = length - 1;

        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

}
