package com.priyakdey.bst;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author priyakdey
 */
public class KthLargestValueInBST {

    // iterative traversal from the right. And keep popping nodes, till k > 1.
    //
    // TODO:im just thinking if there is a better way for this since its a BST!!

    public int findKthLargestValueInBst(BST tree, int k) {
        if (tree == null) {
            throw new IllegalArgumentException("tree is null");
        }

        Deque<BST> stack = new ArrayDeque<>();

        BST curr = tree;
        while (curr != null) {
            stack.push(curr);
            curr = curr.right;
        }

        while (!stack.isEmpty() && k > 1) {
            curr = stack.pop();
            k--;

            BST child = curr.left;
            while (child != null) {
                stack.push(child);
                child = child.right;
            }
        }

        // This is production code. But algoexpert being a dsa platform
        // expects the last node in the sequence no matter how large k is.
        // So we do it - like maniacs !!
        //
        // if (stack.isEmpty()) {
        //    throw new IllegalArgumentException("not enough nodes");
        // }
        //

        return !stack.isEmpty() ? stack.peek().value : curr.value;
    }

}
