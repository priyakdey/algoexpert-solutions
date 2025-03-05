package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MergingLinkedList {

    // Find the difference in length. Then move a pointer by that
    // many nodes for the longer list and another from the shorter list head.
    // Then iterate till both pointers point to intersection node.
    // Idea is to offset one of the pointers so that it is like traversing
    // same length of lists, which can help in finding the intersection node.

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList mergingLinkedLists(LinkedList linkedListOne,
                                         LinkedList linkedListTwo) {
        int length1 = findLength(linkedListOne);
        int length2 = findLength(linkedListTwo);

        LinkedList curr1 = linkedListOne, curr2 = linkedListTwo;
        int diff = length1 - length2;
        if (diff < 0) {
            curr1 = linkedListTwo;
            curr2 = linkedListOne;
        }

        diff = Math.abs(diff);
        while (diff > 0) {
            curr1 = curr1.next;
            diff--;
        }

        while (curr1 != null && curr2 != null && curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return curr1 == curr2 ? curr1 : null;
    }

    private int findLength(LinkedList list) {
        int length = 0;
        LinkedList curr = list;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        return length;
    }

}
