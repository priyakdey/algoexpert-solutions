package com.priyakdey.algoexpersolutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class LargestRectangleUnderSkyline {

    // Use a monotonic stack to find left/right bounds for each building where the height drops —
    // compute max area as height × width.
    //
    // Forward pass sets right boundary (next smaller on right);
    // backward pass sets left boundary (next smaller on left).
    // Width = right - left, and area = height × width — take max across all bars.

    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        int length = buildings.size();
        int[] leftIndices = new int[length];
        int[] rightIndices = new int[length];
        Arrays.fill(rightIndices, length);

        Deque<Building> stack = new ArrayDeque<>(length);

        for (int i = 0; i < length; i++) {
            int height = buildings.get(i);
            Building building = new Building(height, i);

            while (!stack.isEmpty() && building.height < stack.peek().height) {
                Building top = stack.pop();
                rightIndices[top.index] = i;
            }

            stack.push(building);
        }

        stack.clear();

        for (int i = length - 1; i >= 0; i--) {
            int height = buildings.get(i);
            Building building = new Building(height, i);

            while (!stack.isEmpty() && building.height < stack.peek().height) {
                Building top = stack.pop();
                leftIndices[top.index] = i + 1;
            }

            stack.push(building);
        }

        int maxArea = 0;

        for (int i = 0; i < length; i++) {
            int height = buildings.get(i);
            int width = (rightIndices[i] - leftIndices[i]) * 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private record Building(int height, int index) {
    }

}
