package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SearchForRange {

    // Use binary search for target and target + 1

    public static int[] searchForRange(int[] array, int target) {
        int leftIndex = findStartingIndexOf(array, target);
        if (leftIndex == -1 || array[leftIndex] != target) {
            return new int[]{-1, -1};
        }

        if (target == Integer.MAX_VALUE) {
            return new int[]{leftIndex, array.length - 1};
        }
        int rightIndex = findStartingIndexOf(array, target + 1);
        if (rightIndex == -1) {
            return new int[]{leftIndex, array.length - 1};
        }

        return new int[]{leftIndex, rightIndex - 1};
    }

    private static int findStartingIndexOf(int[] array, int target) {
        int left = 0, right = array.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }
    
}
