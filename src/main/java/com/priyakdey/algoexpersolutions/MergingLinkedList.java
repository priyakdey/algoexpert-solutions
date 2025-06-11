package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class MergingLinkedList {

    // Align both lists by length and walk together to find the merging node
    // (intersection point by reference).
    //
    // Advance the longer list by the length difference, then move both pointers in sync.
    // Return the node where both pointers meet — they point to the same memory reference,
    // not just same value.

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        if (linkedListOne == null && linkedListTwo == null) return null;
        if (linkedListOne == null) return linkedListTwo;
        if (linkedListTwo == null) return linkedListOne;

        int lengthOne = getLength(linkedListOne);
        int lengthTwo = getLength(linkedListTwo);
        int diff = lengthOne - lengthTwo;

        LinkedList currOne = linkedListOne;
        LinkedList currTwo = linkedListTwo;

        if (diff > 0) {
            while (diff > 0) {
                currOne = currOne.next;
                diff--;
            }
        } else if (diff < 0) {
            while (diff < 0) {
                currTwo = currTwo.next;
                diff++;
            }
        }

        while (currOne != null && currTwo != null && currOne != currTwo) {
            currOne = currOne.next;
            currTwo = currTwo.next;
        }

        return currOne == null || currTwo == null ? null : currOne;
    }

    private int getLength(LinkedList list) {
        LinkedList curr = list;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        return length;
    }

}
