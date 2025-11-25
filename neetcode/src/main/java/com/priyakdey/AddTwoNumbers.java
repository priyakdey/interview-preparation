package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        int carry = 0;

        while (curr1 != null && curr2 != null) {
            int val = curr1.val + curr2.val + carry;
            carry = val / 10;
            val = val % 10;

            curr.next = new ListNode(val);
            curr = curr.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            int val = curr1.val + carry;
            carry = val / 10;
            val = val % 10;

            curr.next = new ListNode(val);
            curr = curr.next;
            curr1 = curr1.next;
        }
        
        while (curr2 != null) {
            int val = curr2.val + carry;
            carry = val / 10;
            val = val % 10;

            curr.next = new ListNode(val);
            curr = curr.next;
            curr2 = curr2.next;
        }

        if (carry == 1) {
            curr.next = new ListNode(1);
        }

        return dummyHead.next;
    }

}
