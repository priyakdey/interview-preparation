package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class P0901 {

    private final Deque<Pair> stack;

    public P0901() {
        this.stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int streak = 1;
        while (!stack.isEmpty() && price >= stack.peek().price) {
            streak += stack.pop().streak;
        }

        stack.push(new Pair(price, streak));
        return streak;
    }

    private record Pair(int price, int streak) {
    }

}
