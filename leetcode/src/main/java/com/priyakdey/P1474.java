package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P1474 {

    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);

        ListNode curr = head;
        ListNode _curr = dummy;
        int _m = m, _n = n;

        while (curr != null) {
            // keep first m nodes
            while (curr != null && _m > 0) {
                _curr.next = curr;
                _curr = _curr.next;
                curr = curr.next;
                _m--;
            }

            // skip next n nodes
            while (curr != null && _n > 0) {
                curr = curr.next;
                _n--;
            }

            // reset counters
            _m = m;
            _n = n;
        }

        return dummy.next;
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
