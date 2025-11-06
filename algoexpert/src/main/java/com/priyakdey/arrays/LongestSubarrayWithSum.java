package com.priyakdey.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class LongestSubarrayWithSum {

    //  Use prefix sums and a hashmap to record the earliest index where a given prefix sum occurs.
    //  For each index i compute currSum = sum(array[0..i]).
    //  If there exists an index j with prefix sum = currSum - targetSum then
    //  subarray[j+1, i] has the target sum.
    //  Use map.putIfAbsent(currSum, i) to preserve the earliest occurrence \
    //  (maximizes subarray length).

    //  Key formula:
    //  compliment = currSum - targetSum
    //  if map contains compliment at index j, subarray is from j+1 to i

    public int[] longestSubarrayWithSum(int[] array, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int left = -1, right = -1;

        int currSum = 0;
        for (int i = 0; i < array.length; i++) {
            currSum += array[i];

            int compliment = currSum - targetSum;
            if (map.containsKey(compliment)) {
                int j = map.get(compliment);
                if (left == -1 || i - (j + 1) > right - left) {
                    left = j + 1;
                    right = i;
                }
            }

            map.putIfAbsent(currSum, i);
        }

        if (left == -1) return new int[0];

        return new int[]{left, right};
    }

}
