package com.priyakdey.bst;

import java.util.ArrayList;

/**
 * @author priyakdey
 */
public class ReconstructBST {

    // This is classical, walk the sequence of elements, and insert them
    // one by one in the BST.

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        BST root = null;

        for (int element : preOrderTraversalValues) {
            BST newNode = new BST(element);
            if (root == null) {
                root = newNode;
                continue;
            }

            BST curr = root;
            BST prev = null;

            while (curr != null) {
                prev = curr;
                if (element < curr.value) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }

            // prev cannot be null, since root is not null
            if (element < prev.value) {
                prev.left = newNode;
            } else {
                prev.right = newNode;
            }
        }

        return root;
    }

}
