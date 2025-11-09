package com.priyakdey.bst;

/**
 * @author Priyak Dey
 */
public class FindClosestValue {

    public static int findClosestValueInBst(BST tree, int target) {
        BST curr = tree;

        int minDiff = Integer.MAX_VALUE;
        int closestValue = -1;

        while (curr != null) {
            int diff = Math.abs(target - curr.value);
            if (diff < minDiff) {
                minDiff = diff;
                closestValue = curr.value;
            }

            if (target < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return closestValue;
    }

}
