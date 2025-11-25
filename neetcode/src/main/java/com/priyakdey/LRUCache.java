package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class LRUCache {

    // NOTE: FUCK YEAH, no NPE in 1st try.
    // Just code it raw and then refactor. You should be good.
    // Remember this when you down!!

    private final int capacity;

    private final Map<Integer, Node> cache;

    private Node head;
    private Node tail;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        makeHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            makeHead(node);
            return;
        }

        evictLRU();
        Node node = new Node(key, value);
        cache.put(key, node);
        addHead(node);
    }

    private void addHead(Node node) {
        if (size == 0) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    private void evictLRU() {
        if (size == capacity) {
            int evictKey = tail.key;
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                Node prev = tail.prev;
                prev.next = null;
                tail = prev;
            }
            size--;
            cache.remove(evictKey);
        }
    }


    private void makeHead(Node node) {
        if (size == 1 || node == head) {
            return;     // nothing to do here
        } else if (node == tail) {
            Node prev = tail.prev;
            prev.next = null;
            tail.prev = null;
            tail = prev;

            node.next = head;
            head.prev = node;
            head = node;
        } else {
            Node next = node.next;
            Node prev = node.prev;
            next.prev = prev;
            prev.next = next;

            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private static class Node {
        private final int key;
        private int value;
        private Node prev;
        private Node next;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

}
