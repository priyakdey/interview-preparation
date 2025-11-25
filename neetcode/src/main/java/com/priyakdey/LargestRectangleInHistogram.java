package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        Deque<Pair> stack = new ArrayDeque<>();
        int[] rightBounds = findIndexOfNextSmallerElement(heights, stack);
        stack.clear();
        int[] leftBounds = findIndexOfPrevSmallerElement(heights, stack);

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (rightBounds[i] - leftBounds[i] + 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private int[] findIndexOfNextSmallerElement(int[] heights, Deque<Pair> stack) {
        int length = heights.length;
        int[] indices = new int[length];
        Arrays.fill(indices, length - 1);

        for (int i = 0; i < length; i++) {
            int height = heights[i];

            while (!stack.isEmpty() && height < stack.peek().height) {
                Pair pair = stack.pop();
                indices[pair.index] = i - 1;
            }

            stack.push(new Pair(height, i));
        }

        return indices;
    }

    private int[] findIndexOfPrevSmallerElement(int[] heights, Deque<Pair> stack) {
        int length = heights.length;
        int[] indices = new int[length];
        Arrays.fill(indices, 0);

        for (int i = length - 1; i >= 0; i--) {
            int height = heights[i];

            while (!stack.isEmpty() && height < stack.peek().height) {
                Pair pair = stack.pop();
                indices[pair.index] = i + 1;
            }

            stack.push(new Pair(height, i));
        }

        return indices;
    }

    private record Pair(int height, int index) {
    }

}
