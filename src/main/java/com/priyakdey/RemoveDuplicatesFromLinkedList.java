package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class RemoveDuplicatesFromLinkedList {

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Take a pointer to the head, one pointer to iterate. Always look back
    // last attached node, if values are not same, attach a new node, and move
    // both the pointers, else move the iteration pointer

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        if (linkedList == null || linkedList.next == null) {
            return linkedList;
        }

        LinkedList curr = linkedList, prev = linkedList;

        while (curr != null) {
            if (curr.value != prev.value) {
                prev.next = curr;
                prev = prev.next;
            }
            curr = curr.next;
        }

        prev.next = null;
        return linkedList;
    }

}
