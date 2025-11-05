package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P1265 {

    interface ImmutableListNode {
        public void printValue(); // print the value of this node.

        public ImmutableListNode getNext(); // return the next node.
    }

    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) return;
        ImmutableListNode node = head.getNext();
        printLinkedListInReverse(node);
        head.printValue();
    }

}
