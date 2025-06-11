package com.priyakdey.algoexpersolutions;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class RadixSort {

    // Implements radix sort for non-negative integers using stable counting sort per digit
    // (units, tens, hundreds...).
    //
    // Each pass uses counting sort by digit position (LSD to MSD), ensuring stability.
    // Fails early for negative numbers since radix sort assumes a non-negative range.

    public ArrayList<Integer> radixSort(ArrayList<Integer> array) {
        Objects.requireNonNull(array);
        int length = array.size();
        if (length < 2) return array;

        int maxElement = array.get(0);
        int minElement = array.get(0);
        for (int num : array) {
            maxElement = Math.max(maxElement, num);
            minElement = Math.min(minElement, num);
        }

        if (minElement < 0) {
            throw new IllegalArgumentException("Can only sort in the range [0..k]");
        }

        for (int place = 1; maxElement / place > 0; place *= 10) {
            countingSort(array, place);
        }

        return array;
    }

    private void countingSort(ArrayList<Integer> array, int place) {
        int[] freqArr = new int[10];    // [0..9]

        for (int num : array) {
            int digit = (num / place) % 10;
            freqArr[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            freqArr[i] += freqArr[i - 1];
        }

        int length = array.size();
        int[] temp = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            int num = array.get(i);
            int digit = (num / place) % 10;
            temp[freqArr[digit] - 1] = num;
            freqArr[digit]--;
        }

        for (int i = 0; i < length; i++) {
            array.set(i, temp[i]);
        }
    }

}
