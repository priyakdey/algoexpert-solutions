package com.priyakdey;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Priyak Dey
 */
public class ContinuousMedianHandler {

    // Use max heap to store left half and min heap to store right half
    // elements.
    // POst insert balance the heaps so size diff always within 1.

    double median = 0;

    private final PriorityQueue<Integer> leftHalf =
            new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> rightHalf = new PriorityQueue<>();

    public void insert(int number) {
        if (number <= (int) median) {
            leftHalf.offer(number);
        } else {
            rightHalf.offer(number);
        }
        balance();
        setMedian();
    }

    public double getMedian() {
        return median;
    }

    private void balance() {
        int leftHalfSize  = leftHalf.size();
        int rightHalfSize = rightHalf.size();
        int diff = leftHalfSize - rightHalfSize;
        if (diff > 1) {
            rightHalf.offer(leftHalf.poll());
        } else if (diff < -1) {
            leftHalf.offer(rightHalf.poll());
        }
    }

    private void setMedian() {
        int leftHalfSize  = leftHalf.size();
        int rightHalfSize = rightHalf.size();
        int diff = leftHalfSize - rightHalfSize;
        if (diff == 0) {
            median = (leftHalf.peek() + rightHalf.peek()) / 2.0;
        } else if (diff > 0) {
            median = leftHalf.peek();
        } else {
            median = rightHalf.peek();
        }
    }

}
