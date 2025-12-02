package com.priyakdey;

import java.util.PriorityQueue;

/**
 * @author Priyak Dey
 */
public class KthLargest {

    // Use a min-heap of size k to keep track of the
    // k largest elements.
    // Since min heap, root is the kth largest element.

    private final PriorityQueue<Integer> pq;
    private final int capacity;

    public KthLargest(int k, int[] nums) {
        this.capacity = k;
        this.pq = new PriorityQueue<>(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (pq.size() == capacity) {
            val = Math.max(val, pq.poll());
        }

        pq.offer(val);
        return pq.peek();
    }

}
