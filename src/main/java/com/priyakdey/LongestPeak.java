package com.priyakdey;

public class LongestPeak {

    public static int longestPeak(int[] array) {
        int longestPeakLength = 0;
        int i = 1; // Start from the second element since a peak cannot start at the first element

        while (i < array.length - 1) {
            boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];
            if (!isPeak) {
                i++;
                continue;
            }

            // Explore left
            int leftIdx = i - 2;
            while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
                leftIdx--;
            }

            // Explore right
            int rightIdx = i + 2;
            while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
                rightIdx++;
            }

            // Calculate peak length
            int currentPeakLength = rightIdx - leftIdx - 1;
            longestPeakLength = Math.max(longestPeakLength, currentPeakLength);

            // Move i past this peak
            i = rightIdx;
        }

        return longestPeakLength;
    }
}
