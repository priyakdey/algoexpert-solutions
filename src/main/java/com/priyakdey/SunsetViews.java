package com.priyakdey;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class SunsetViews {

    // Use a stack to find out if any building present with gte height
    // than current building.

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        return Objects.equals(direction, "EAST")
                ? sunsetViewsEast(buildings)
                : sunsetViewsWest(buildings);
    }

    private ArrayList<Integer> sunsetViewsEast(int[] buildings) {
        int length = buildings.length;
        boolean[] cannotSee = new boolean[length];

        Deque<Building> stack = new ArrayDeque<>();

        for (int position = 0; position < length; position++) {
            int height = buildings[position];
            while (!stack.isEmpty() && stack.peek().height <= height) {
                Building building = stack.pop();
                cannotSee[building.position] = true;
            }

            stack.push(new Building(buildings[position], position));
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int position = 0; position < length; position++) {
            if (!cannotSee[position]) {
                result.add(position);
            }
        }

        return result;
    }

    private ArrayList<Integer> sunsetViewsWest(int[] buildings) {
        int length = buildings.length;
        boolean[] cannotSee = new boolean[length];

        Deque<Building> stack = new ArrayDeque<>();

        for (int position = length - 1; position >= 0; position--) {
            int height = buildings[position];
            while (!stack.isEmpty() && stack.peek().height <= height) {
                Building building = stack.pop();
                cannotSee[building.position] = true;
            }

            stack.push(new Building(buildings[position], position));
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int position = 0; position < length; position++) {
            if (!cannotSee[position]) {
                result.add(position);
            }
        }

        return result;
    }


    private record Building(int height, int position) {
    }

}
