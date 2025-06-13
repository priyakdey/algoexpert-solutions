package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class WaterArea {

    // Precompute max heights to the left and right for each index —
    // trapped water = min(left, right) − height (if positive).
    //
    // Left-to-right pass stores running max into rightBoundHeights; right-to-left
    // stores into leftBoundHeights.
    // Final pass computes water above each bar using min(left, right) - height.

    // TODO: This can be done in O(1) space complexity, taking two pointer technique

    public static int waterArea(int[] heights) {
        int length = heights.length;
        if (length < 3) return 0;

        int[] rightBoundHeights = new int[length];
        int boundHeight = heights[0];
        for (int i = 1; i < length; i++) {
            boundHeight = Math.max(boundHeight, heights[i]);
            rightBoundHeights[i] = boundHeight;
        }


        int[] leftBoundHeights = new int[length];
        boundHeight = heights[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            boundHeight = Math.max(boundHeight, heights[i]);
            leftBoundHeights[i] = boundHeight;
        }

        int totalArea = 0;

        for (int i = 1; i < length - 1; i++) {
            int height = heights[i];
            boundHeight = Math.min(rightBoundHeights[i], leftBoundHeights[i]);
            if (boundHeight > height) {
                totalArea += (boundHeight - height) * 1;
            }
        }

        return totalArea;
    }

    private record Building(int height, int index) {
    }

}
