package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P0708 {

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        } else if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }

        Node curr = head;
        while (curr.next != head) {
            if (insertVal == curr.val) {
                break;
            }
            if (curr.val < curr.next.val && insertVal > curr.val
                    && insertVal < curr.next.val) {
                break;
            }
            if (curr.val > curr.next.val) {
                if (insertVal < curr.val && insertVal < curr.next.val) {
                    break;
                } else if (insertVal > curr.val) {
                    break;
                }
            }
            curr = curr.next;
        }

        Node next = curr.next;
        curr.next = node;
        node.next = next;
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
