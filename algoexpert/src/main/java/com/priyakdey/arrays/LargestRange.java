package com.priyakdey.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class LargestRange {

    // Push all elements into the set.
    // Iterate over each element in the array, if not in set, skip it.
    // If in set, expand from (num - 1) till, (num - 1) is present in set, remember to evict it
    // from the set if present.
    // Do the same by increasing from (num + 1).
    // This would give the range of consecutive elements, which are present in the original array.
    // Then we can simply do a largest range check and reset the values.


    // If space is a constraint, we can do a sort and then move around the cursor,
    // if array[curr] == array[curr] + 1 || array[curr] == array[curr] (duplicates).
    // to check lartest range of numbers presents in the array.

    public static int[] largestRange(int[] array) {
        int left = array[0], right = array[0];
        int largestRange = 1;

        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }

        for (int num : array) {
            if (!set.contains(num)) continue;

            int l = num - 1;
            while (set.contains(l)) {
                set.remove(l--);
            }
            int r = num + 1;
            while (set.contains(r)) {
                set.remove(r++);
            }

            int range = (r - 1) - (l + 1) + 1;
            if (range > largestRange) {
                largestRange = range;
                left = l + 1;
                right = r - 1;
            }
        }

        return new int[]{left, right};
    }

}
