package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ValidStringParenthesis {

    // Since its only ()*, we can do +1 for (, -1 for ) and +1, 0 and -1
    // for * and check if any path does work out.
    // TODO: This is a recursive solution, this probably can have a more greedy
    // solution.

    public boolean checkValidString(String s) {
        return checkValid(s, 0, 0);
    }

    private boolean checkValid(String s, int index, int weight) {
        if (weight < 0) {
            return false;
        }

        if (index == s.length()) {
            return weight == 0;
        }

        char ch = s.charAt(index);

        if (ch == '(') {
            return checkValid(s, index + 1, weight + 1);
        } else if (ch == ')') {
            return checkValid(s, index + 1, weight - 1);
        } else if (ch == '*') {
            return checkValid(s, index + 1, weight + 1)
                    || checkValid(s, index + 1, weight)
                    || checkValid(s, index + 1, weight - 1);
        } else {
            return false;
        }
    }

}
