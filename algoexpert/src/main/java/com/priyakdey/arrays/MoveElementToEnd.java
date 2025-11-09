package com.priyakdey.arrays;

import java.util.Collections;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class MoveElementToEnd {

    // Since we don't need to maintain the order, we can take two pointers from left
    // and right.
    // And swap the elements and move the pointers, depending on the conditions.

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int left = 0, right = array.size() - 1;

        while (left < right) {
            if (array.get(left) == toMove && array.get(right) == toMove) {
                right--;
            } else if (array.get(left) == toMove && array.get(right) != toMove) {
                Collections.swap(array, left, right);
                left++;
                right--;
            } else if (array.get(left) != toMove && array.get(right) == toMove) {
                left++;
                right--;
            } else if (array.get(left) != toMove && array.get(right) != toMove) {
                left++;
            }
        }

        return array;
    }

}
