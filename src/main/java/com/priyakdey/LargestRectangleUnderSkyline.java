package com.priyakdey;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class LargestRectangleUnderSkyline {

    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        Objects.requireNonNull(buildings);
        int length = buildings.size();
        if (length == 0) return 0;
        if (length == 1) return buildings.getFirst() * 1;

        Deque<Integer> stack = new ArrayDeque<>();

        int[] leftBoundIndex = new int[length];
        Arrays.fill(leftBoundIndex, 0);

        int[] rightBoundIndex = new int[length];
        Arrays.fill(rightBoundIndex, length - 1);

        for (int i = 0; i < length; i++) {
            int height = buildings.get(i);
            while (!stack.isEmpty() && height < buildings.get(stack.peek())) {
                rightBoundIndex[stack.pop()] = i - 1;
            }

            stack.push(i);
        }

        stack.clear();

        for (int i = length - 1; i >= 0; i--) {
            int height = buildings.get(i);
            while (!stack.isEmpty() && height < buildings.get(stack.peek())) {
                leftBoundIndex[stack.pop()] = i + 1;
            }

            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            int width = rightBoundIndex[i] - leftBoundIndex[i] + 1;
            int height = buildings.get(i);
            int area = width * height;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleUnderSkyline().largestRectangleUnderSkyline(
            new ArrayList<>(List.of(1, 3, 3, 2, 4, 1, 5, 3, 2))));
    }

}
