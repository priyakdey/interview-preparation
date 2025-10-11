package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class RemoveNodeFromEndOfLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = head;

        while (n-- > 1) {
            tail = tail.next;
        }

        ListNode prev = null;
        ListNode remove = head;

        while (tail.next != null) {
            prev = remove;
            remove = remove.next;
            tail = tail.next;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = remove.next;
        }

        return head;
    }

}
