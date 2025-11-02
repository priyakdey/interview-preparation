package com.priyakdey;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class P1429 {

    private final Deque<Integer> queue;
    private final Map<Integer, Integer> freqCounter;

    public P1429(int[] nums) {
        this.queue = new LinkedList<>();
        this.freqCounter = new HashMap<>();

        for (int num : nums) {
            int freq = this.freqCounter.compute(num, (k, v) -> v == null ? 1 : v + 1);
            if (freq == 1) {
                this.queue.offer(num);
            }
        }

    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && freqCounter.get(queue.peek()) != 1) {
            queue.poll();
        }

        return !queue.isEmpty() ? queue.peek() : -1;
    }

    public void add(int value) {
        int freq = freqCounter.compute(value, (k, v) -> v == null ? 1 : v + 1);
        if (freq == 1) {
            this.queue.offer(value);
        }
    }

}
