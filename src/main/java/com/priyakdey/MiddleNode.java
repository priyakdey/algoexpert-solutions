package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MiddleNode {

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Take two pointers from head, run one pointer twice as fast
    // as the other. The second pointer lands on the mid.

    public LinkedList middleNode(LinkedList linkedList) {
        LinkedList mid = linkedList, curr = linkedList;

        while (curr != null && curr.next != null) {
            mid = mid.next;
            curr = curr.next.next;
        }

        return mid;
    }

}
