package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class CountInversions {

    // Count inversions using modified merge sort — track how many right-side elements cross over
    // left ones during merge.

    public int countInversions(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    private int mergeSort(int[] array, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int inversions = 0;
        inversions += mergeSort(array, left, mid);
        inversions += mergeSort(array, mid + 1, right);
        inversions += merge(array, left, mid, right);
        return inversions;
    }

    private int merge(int[] array, int left, int mid, int right) {
        int length = right - left + 1;

        int[] buf = new int[length];

        int inversions = 0;
        int i = left, j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                buf[k++] = array[i++];
            } else {
                buf[k++] = array[j++];
                inversions += mid - i + 1;
            }
        }

        while (i <= mid) {
            buf[k++] = array[i++];
        }

        while (j <= right) {
            buf[k++] = array[j++];
        }

        System.arraycopy(buf, 0, array, left, length);

        return inversions;
    }

}
