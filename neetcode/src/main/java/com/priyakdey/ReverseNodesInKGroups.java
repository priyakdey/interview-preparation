package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ReverseNodesInKGroups {

    public ListNode reverseKGroup(ListNode head, int k) {
        // find head and tail of the group
        // keep a track of prev node of the group, so we can reattach

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode curr = head;


        while (curr != null) {
            int temp = k;
            ListNode groupHead = curr;
            while (curr != null && temp > 1) {
                curr = curr.next;
                temp--;
            }

            if (curr == null) break;

            ListNode groupTail = curr;
            prev.next = null;
            ListNode nextGroupHead = curr.next;
            groupTail.next = null;
            ListNode[] nodes = reverse(groupHead);
            groupHead = nodes[0];
            groupTail = nodes[1];

            prev.next = groupHead;
            groupTail.next = nextGroupHead;

            prev = groupTail;
            curr = nextGroupHead;
        }

        return dummyHead.next;
    }

    private ListNode[] reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return new ListNode[]{prev, head};
    }

}
