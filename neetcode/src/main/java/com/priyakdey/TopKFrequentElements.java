package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(k, Comparator.comparingInt(Pair::freq));

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int value = entry.getKey();
            int freq = entry.getValue();

            if (pq.size() < k) {
                pq.offer(new Pair(value, freq));
            } else if (freq > Objects.requireNonNull(pq.peek()).freq) {
                    pq.poll();
                    pq.offer(new Pair(value, freq));
            }
        }

        int[] res = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll().value;
        }

        return res;
    }

    private record Pair(int value, int freq) {
    }
}
