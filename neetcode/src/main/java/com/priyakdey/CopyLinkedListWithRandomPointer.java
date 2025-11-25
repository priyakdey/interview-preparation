package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class CopyLinkedListWithRandomPointer {

    // NOTE: can we do this in a single pass?
    // We can keep track of prev node, and map the clones, but the random pointers
    // are a pain, because it might cause jumping all over the place.
    // Even if we solve this, at CPU level with data locality, predictable iteration
    // wins over random jumps - maybe a good idea to see how it actually effects
    // if we can write this random jump algo.

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        {
            Node curr = head;
            while (curr != null) {
                Node clone = new Node(curr.val);
                map.put(curr, clone);
                curr = curr.next;
            }
        }

        {
            Node curr = head;
            while (curr != null) {
                Node next = curr.next;
                Node random = curr.random;
                Node clone = map.get(curr);
                clone.next = map.get(next);
                clone.random = map.get(random);
                curr = next;
            }
        }

        return map.get(head);
    }

    // Definition for a Node.
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
