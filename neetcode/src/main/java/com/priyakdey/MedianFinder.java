package com.priyakdey;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Priyak Dey
 */
public class MedianFinder {

    private final PriorityQueue<Integer> lowerHalf;
    private final PriorityQueue<Integer> higherHalf;
    private double median;

    public MedianFinder() {
        this.lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
        this.higherHalf = new PriorityQueue<>();
        this.median = 0.0;
    }

    public void addNum(int num) {
        if (num <= median) {
            lowerHalf.offer(num);
        } else {
            higherHalf.offer(num);
        }

        balance();
        setMedian();
    }

    public double findMedian() {
        return median;
    }

    private void setMedian() {
        int diff = lowerHalf.size() - higherHalf.size();

        if (diff == 0) {
            median = (lowerHalf.peek() + higherHalf.peek()) / 2.0;
        } else if (diff == 1) {
            median = lowerHalf.peek();
        } else {
            median = higherHalf.peek();
        }

    }

    private void balance() {
        int diff = lowerHalf.size() - higherHalf.size();
        if (diff > 1) {
            higherHalf.offer(lowerHalf.poll());
        } else if (diff < -1) {
            lowerHalf.offer(higherHalf.poll());
        }
    }

}
