package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int length = height.length;

        if (length < 3) return 0;

        int[] leftBound =  new int[length];
        int[] rightBound = new int[length];

        int left = 1, right = length - 2;

        leftBound[0] = height[0];
        rightBound[length - 1] = height[length - 1];

        while (left < length - 1) {
            leftBound[left] = Math.max(leftBound[left - 1], height[left]);
            rightBound[right] = Math.max(rightBound[right + 1], height[right]);
            left++;
            right--;
        }

        int area = 0;
        for (int i = 1; i < length - 1; i++) {
            int boundHeight = Math.min(leftBound[i], rightBound[i]);
            if (boundHeight > height[i]) {
                area += (boundHeight - height[i]) * 1;
            }
        }

        return area;
    }

}
