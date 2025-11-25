package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class MinStack {

    private final Deque<Pair> stack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Pair(val, val));
            return;
        }

        stack.push(new Pair(val, Math.min(val, getMin())));
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }

        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }

        return stack.peek().value;
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }

        return stack.peek().minValue;
    }

    private record Pair(int value, int minValue) {
    }

}
