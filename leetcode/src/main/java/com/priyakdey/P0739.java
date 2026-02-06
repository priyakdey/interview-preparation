package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class P0739 {

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Pair> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];


        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > stack.peek().temperature) {
                Pair p = stack.pop();
                result[p.days] = i - p.days;
            }

            stack.push(new Pair(temperature, i));
        }

        return result;
    }

    private record Pair(int temperature, int days) {
    }

}
