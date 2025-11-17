package com.priyakdey.bst;

import java.util.List;

/**
 * @author priyakdey
 */
public class BSTTraversal {

    // Classical traversal patterns. Nothing much to write for notes.
    // You should be able to do this in sleep, else there is a problem
    // friend!!!!

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) return array;

        inOrderTraverse(tree.left, array);
        array.add(tree.value);
        inOrderTraverse(tree.right, array);

        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) return array;

        array.add(tree.value);
        preOrderTraverse(tree.left, array);
        preOrderTraverse(tree.right, array);

        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) return array;

        postOrderTraverse(tree.left, array);
        postOrderTraverse(tree.right, array);
        array.add(tree.value);

        return array;
    }

}
