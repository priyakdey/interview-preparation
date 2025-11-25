package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class EvaluateRPN {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> ops = Set.of("+", "-", "*", "/");

        for (String token : tokens) {
            if (ops.contains(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("invalid expression");
                }
                int rhs = stack.pop();
                int lhs = stack.pop();
                stack.push(eval(lhs, rhs, token));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.peek();
    }

    // NOTE: this can overflow, since no constraints are given
    // in the dsa problem, we can consider it will not.
    // This does not work in production!!
    private int eval(int lhs, int rhs, String op) {
        return switch (op) {
            case "+" -> lhs + rhs;
            case "-" -> lhs - rhs;
            case "*" -> lhs * rhs;
            case "/" -> {
                if (rhs == 0) throw new ArithmeticException("NaN");
                yield lhs / rhs;
            }
            default -> throw new IllegalArgumentException("invalid op " + op);
        };
    }

}
