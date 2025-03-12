package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class WaterArea {

    // Iterate from left to right to find the left side bounding height.
    // Do the same for right to left.
    // Bounding height is min(left bound, right bound)

    public static int waterArea(int[] heights) {
        int length = heights.length;
        if (length < 3) return 0;

        int[] leftBounds = new int[length];
        int maxHeight = heights[0];
        for (int i = 1; i < length; i++) {
            maxHeight = Math.max(maxHeight, heights[i - 1]);
            leftBounds[i] = maxHeight;
        }


        int[] rightBounds = new int[length];
        maxHeight = heights[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            maxHeight = Math.max(maxHeight, heights[i + 1]);
            rightBounds[i] = maxHeight;
        }

        int totalWater = 0;
        for (int i = 1; i < length - 1; i++) {
            int boundHeight = Math.min(rightBounds[i], leftBounds[i]);
            int height = heights[i];
            int diff = boundHeight - height;
            if (diff > 0) {
                totalWater += diff * 1;
            }
        }

        return totalWater;
    }

}
