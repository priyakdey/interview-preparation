package com.priyakdey;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Priyak Dey
 */
public class MergeKSortedLinkedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        int length = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(length,
                Comparator.comparing(node -> node.val));

        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        if (pq.isEmpty()) return null;

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) pq.offer(node.next);
        }

        return dummyHead.next;
    }

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

}
