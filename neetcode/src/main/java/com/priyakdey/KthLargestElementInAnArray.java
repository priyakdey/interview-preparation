package com.priyakdey;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Priyak Dey
 */
public class KthLargestElementInAnArray {

    // Use the min-heap trick.

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,
                Comparator.naturalOrder());

        for (int num : nums) {
            if (pq.size() == k) {
                num = Math.max(num, pq.poll());
            }

            pq.offer(num);
        }

        return pq.peek();
    }

}
