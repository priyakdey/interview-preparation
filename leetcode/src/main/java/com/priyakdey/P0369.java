package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P0369 {

    public ListNode plusOne(ListNode head) {
        head = reverse(head);

        int carry = 1;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            int value = curr.val + carry;
            carry = value / 10;
            value = value % 10;
            curr.val = value;
            prev = curr;
            curr = curr.next;
        }

        if (carry == 1) {
            prev.next = new ListNode(1);
        }

        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static class ListNode {
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

}
