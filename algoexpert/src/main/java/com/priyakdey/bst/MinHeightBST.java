package com.priyakdey.bst;

import java.util.List;

/**
 * @author priyakdey
 */
public class MinHeightBST {

    // We can enter elements sequentially, but it risks a skewed tree, since
    // input is sorted.
    // So we take root as middle of the array/slice, and make sure left is left subtree
    // and right half is subtree.
    //
    // To save space, we use slice/view and not actual accumulation and generation of a new array.

    public static BST minHeightBst(List<Integer> array) {
        return minHeightBst(array, 0, array.size() - 1);
    }

    private static BST minHeightBst(List<Integer> array, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        BST root = new BST(array.get(mid));

        root.left = minHeightBst(array, left, mid - 1);
        root.right = minHeightBst(array, mid + 1, right);

        return root;
    }
}
