package com.priyakdey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class P0716 {

    private Node head;
    private Node tail;

    private final Heap heap;

    public P0716() {
        this.head = null;
        this.tail = null;
        this.heap = new Heap();
    }

    public void push(int x) {
        Node node = new Node(x);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        heap.push(node);
    }

    public int pop() {
        Node node = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        heap.remove(node);
        return node.value;
    }

    public int top() {
        return tail.value;
    }

    public int peekMax() {
        return heap.peek().value;
    }

    public int popMax() {
        Node node = heap.pop();

        if (head == tail) {
            head = null;
            tail = null;
        } else if (head == node) {
            head = head.next;
            head.prev = null;
        } else if (tail == node) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        return node.value;
    }

    private static class Node {
        private final int value;
        private Node next;
        private Node prev;

        private Node(int value) {
            this.value = value;
        }
    }

    private static class Heap {
        private final List<Node> nodes;

        private Heap() {
            this.nodes = new ArrayList<>();
        }

        private void push(Node node) {
            nodes.add(node);

            int curr = nodes.size() - 1;

            while (curr > 0) {
                int parent = (curr - 1) / 2;
                if (nodes.get(curr).value >= nodes.get(parent).value) {
                    Collections.swap(nodes, curr, parent);
                }
                curr = parent;
            }

        }

        private Node pop() {
            Node root = nodes.getFirst();
            Collections.swap(nodes, 0, nodes.size() - 1);

            nodes.removeLast();
            int curr = 0;
            while (curr < nodes.size() - 1) {
                int leftIndex = (2 * curr) + 1;
                int rightIndex = (2 * curr) + 2;

                if (leftIndex >= nodes.size()) break;

                int swapIndex = leftIndex;
                if (rightIndex < nodes.size()
                        && nodes.get(rightIndex).value > nodes.get(leftIndex).value) {
                    swapIndex = rightIndex;
                }

                if (nodes.get(swapIndex).value >= nodes.get(curr).value) {
                    Collections.swap(nodes, swapIndex, curr);
                }

                curr = swapIndex;
            }

            return root;
        }

        private void heapify(int index) {
            int n = nodes.size();
            int curr = index;

            while (true) {
                int left = (2 * curr) + 1;
                if (left >= n) break;

                int right = left + 1;
                int largest = left;

                if (right < n && nodes.get(right).value > nodes.get(left).value) {
                    largest = right;
                }

                if (nodes.get(largest).value > nodes.get(curr).value) {
                    Collections.swap(nodes, curr, largest);
                    curr = largest;
                } else {
                    break;
                }
            }
        }

        private void remove(Node node) {
            int idx = nodes.indexOf(node);
            if (idx == -1) return;

            int last = nodes.size() - 1;
            if (idx == last) {
                nodes.remove(last);
                return;
            }

            Collections.swap(nodes, idx, last);
            nodes.remove(last);

            // Try percolating up first
            int curr = idx;
            while (curr > 0) {
                int parent = (curr - 1) / 2;
                if (nodes.get(curr).value > nodes.get(parent).value) {
                    Collections.swap(nodes, curr, parent);
                    curr = parent;
                } else {
                    break;
                }
            }

            // If no upward movement happened, percolate down to restore heap
            if (curr == idx) {
                heapify(curr);
            }
        }


        private Node peek() {
            return nodes.getFirst();
        }

    }

}
