package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class ValidParenthesis {

    public boolean isValid(String s) {
        Map<Character, Character> brackets = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (brackets.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

}
