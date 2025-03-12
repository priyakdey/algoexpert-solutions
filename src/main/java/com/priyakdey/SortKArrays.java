package com.priyakdey;

import java.util.PriorityQueue;

/**
 * @author Priyak Dey
 */
public class SortKArrays {

    // Use a minheap of size k + 1, and push k elements always

    public int[] sortKSortedArray(int[] array, int k) {
        int length = array.length;
        if (length < 2) {
            return array;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1);
        int[] sortedArray = new int[length];
        int curr = 0;

        for (int i = 0; i < Math.min(k, length); i++) {
            minHeap.add(array[i]);
        }

        for (int i = k; i < length; i++) {
            minHeap.offer(array[i]);
            sortedArray[curr++] = minHeap.poll();
        }

        while (!minHeap.isEmpty()) {
            sortedArray[curr++] = minHeap.poll();
        }

        return sortedArray;
    }

}
