package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P0346 {

    private Node head;
    private Node tail;

    private final int capacity;

    private int size;

    private double currSum;

    public P0346(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.currSum = 0.0;
    }

    public double next(int val) {
        Node node = new Node(val);

        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else if (size < capacity) {
            tail.next = node;
            tail = node;
            size++;
        } else {
          currSum -= head.val;
          head = head.next;
          tail.next = node;
          tail = node;
        }

        currSum += val;
        return currSum / size;
    }

    private static class Node {
        private final int val;
        private Node next;


        private Node(int val) {
            this.val = val;
        }
    }

}
