package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SumOfLinkedList {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne,
                                       LinkedList linkedListTwo) {
        LinkedList dummyHead = new LinkedList(-1);

        LinkedList curr1 = linkedListOne;
        LinkedList curr2 = linkedListTwo;
        LinkedList curr = dummyHead;

        int carry = 0;
        while (curr1 != null && curr2 != null) {
            int value = curr1.value + curr2.value + carry;
            carry = value / 10;
            value = value % 10;
            curr.next = new LinkedList(value);
            curr = curr.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            int value = curr1.value + carry;
            carry = value / 10;
            value = value % 10;
            curr.next = new LinkedList(value);
            curr = curr.next;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            int value = curr2.value + carry;
            carry = value / 10;
            value = value % 10;
            curr.next = new LinkedList(value);
            curr = curr.next;
            curr2 = curr2.next;
        }

        if (carry == 1) {
            curr.next = new LinkedList(1);
        }

        return dummyHead.next;
    }

}
