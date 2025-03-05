package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class RemoveKthNodeFromEnd {

    // Offset a pointer by k, and the iterate two pointers one from head,
    // one from offset till offset reaches tail. The second pointer is the
    // node to remove.

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList tail = head;
        while (k > 1) {
            tail = tail.next;
            k--;
        }

        LinkedList remove = head, prev = null;

        while (tail.next != null) {
            tail = tail.next;
            prev = remove;
            remove = remove.next;
        }

        if (remove == head) {
            head.value = head.next.value;
            head.next = head.next.next;
        } else {
            prev.next = remove.next;
        }
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
