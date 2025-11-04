package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P0708 {

    // TODO: not finished, start with this.

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        };

        if (head == head.next) {
            head.next = node;
            node.next = head;
            return head;
        }

        Node curr = head.next;
        Node prev = head;

        boolean inserted = false;

        while (curr != head) {
            if (insertVal >= prev.val && insertVal <= curr.val) {
                break;
            }
            prev = curr;
            curr = curr.next;
        }


        if (insertVal <= curr.val && insertVal >= prev.val) {
            prev.next = node;
            node.next = curr;
        } else {
            // this needs to be inserted before prev
            while (curr.next != prev) {
                curr = curr.next;
            }

            curr.next = node;
            node.next = prev;
        }

        return head;
    }

    private static class Node {
        private int val;
        private Node next;

        private Node() {
        }

        private Node(int _val) {
            val = _val;
        }

        private Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

}
