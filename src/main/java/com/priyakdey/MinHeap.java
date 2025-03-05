package com.priyakdey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class MinHeap {

    List<Integer> heap = new ArrayList<>();

    public MinHeap(List<Integer> array) {
        heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
        array.forEach(this::insert);
        return heap;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        while (currentIdx <= endIdx) {
            int leftIdx = currentIdx * 2 + 1;
            int rightIdx = currentIdx * 2 + 2;

            if (leftIdx > endIdx) {
                return;
            }

            int swapIdx = leftIdx;
            if (rightIdx <= endIdx && heap.get(rightIdx) < heap.get(leftIdx)) {
                swapIdx = rightIdx;
            }

            if (heap.get(swapIdx) < heap.get(currentIdx)) {
                Collections.swap(heap, swapIdx, currentIdx);
            } else {
                return;
            }
            currentIdx = swapIdx;
        }
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
        while (currentIdx > 0) {
            int parentIdx = (currentIdx - 1) / 2;
            if (heap.get(currentIdx) < heap.get(parentIdx)) {
                Collections.swap(heap, currentIdx, parentIdx);
            } else {
                return;
            }
            currentIdx = parentIdx;
        }
    }

    public int peek() {
        return heap.getFirst();
    }

    public int remove() {
        int root = heap.get(0);
        Collections.swap(heap, 0, heap.size() - 1);
        heap.removeLast();
        siftDown(0, heap.size() - 1, heap);
        return root;
    }

    public void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1, heap);
    }

}
