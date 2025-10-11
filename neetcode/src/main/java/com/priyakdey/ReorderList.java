package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ReorderList {

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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode mid = findMid(head);

        ListNode head2 = mid.next;
        mid.next = null;

        head2 = reverse(head2);

        ListNode curr1 = head;
        ListNode curr2 = head2;

        while (curr1 != null && curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;

            curr1.next = curr2;
            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode findMid(ListNode head) {
        ListNode mid = head;
        ListNode curr = head.next;

        while (curr != null && curr.next != null) {
            mid = mid.next;
            curr = curr.next.next;
        }

        return mid;
    }

}
