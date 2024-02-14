package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MergeSort {

    public static int[] mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int length = right - left + 1;
        int[] mergedArr = new int[length];

        int curr1 = left, curr2 = mid + 1;
        int curr = 0;

        while (curr1 <= mid && curr2 <= right) {
            if (array[curr1] <= array[curr2]) {
                mergedArr[curr++] = array[curr1++];
            } else {
                mergedArr[curr++] = array[curr2++];
            }
        }

        while (curr1 <= mid) {
            mergedArr[curr++] = array[curr1++];
        }

        while (curr2 <= right) {
            mergedArr[curr++] = array[curr2++];
        }

        System.arraycopy(mergedArr, 0, array, left, length);
    }

}
