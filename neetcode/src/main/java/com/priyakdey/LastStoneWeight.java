package com.priyakdey;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Priyak Dey
 */
public class LastStoneWeight {

    // Push every element to a max heap.
    // Then pop 2 elements till size > 1.
    // And simulate accordingly.

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length,
                Comparator.reverseOrder());

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();
            int diff = Math.abs(x - y);
            if (diff > 0){
                pq.offer(diff);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }

}
