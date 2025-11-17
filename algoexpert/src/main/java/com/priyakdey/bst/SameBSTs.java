package com.priyakdey.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * @author priyakdey
 */
public class SameBSTs {

    // In a BST, since elements are pushed from left to right, we can easily consider
    // first element as root.
    // Means if size of arrays are not same, or root element is not same, we can short circuit and
    // return false.
    // But if true, we can consider creating two arrays. All elements less than root
    // is one array and greater than eq is another array.
    // Do the same for other array, and then recurse down with smaller elements
    // and bigger elements.

    // TODO: find a better solution, where we don't keep allocating new memory
    // every function call.

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.isEmpty() && arrayTwo.isEmpty()) {
            return true;
        }

        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }

        int root = arrayOne.getFirst();

        if (root != arrayTwo.getFirst()) return false;

        List<Integer> smaller1 = new ArrayList<>();
        List<Integer> bigger1 = new ArrayList<>();

        int size = arrayOne.size();
        for (int i = 1; i < size; i++) {
            int element = arrayOne.get(i);
            if (element < root) {
                smaller1.add(element);
            } else {
                bigger1.add(element);
            }
        }

        List<Integer> smaller2 = new ArrayList<>();
        List<Integer> bigger2 = new ArrayList<>();

        // cross-check same values in second tree
        for (int i = 1; i < size; i++) {
            int element = arrayTwo.get(i);
            if (element < root && smaller1.contains(element)) {
                smaller2.add(element);
            } else if (element >= root && bigger1.contains(element)) {
                bigger2.add(element);
            } else {
                return false;       // short-circuit
            }
        }

        return sameBsts(smaller1, smaller2) && sameBsts(bigger1, bigger2);
    }

}
