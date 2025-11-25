package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        Deque<Pair> stack = new ArrayDeque<>(length);

        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > stack.peek().temperature) {
                Pair p = stack.pop();
                result[p.index] = i - p.index;
            }

            stack.push(new Pair(temperature, i));
        }

        return result;
    }

    private record Pair(int temperature, int index) {
    }

}
