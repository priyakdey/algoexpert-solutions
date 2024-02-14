package com.priyakdey;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class SunsetView {

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        return Objects.equals("EAST", direction)
            ? sunsetViewEastFacing(buildings)
            : sunsetViewWestFacing(buildings);
    }

    private ArrayList<Integer> sunsetViewEastFacing(int[] buildings) {
        ArrayList<Integer> views = new ArrayList<>(); // use this as a deque

        for (int i = 0, length = buildings.length; i < length; i++) {
            int height = buildings[i];
            while (!views.isEmpty() && height >= buildings[views.getLast()]) {
                views.removeLast();
            }
            views.add(i);
        }

        return views;
    }

    private ArrayList<Integer> sunsetViewWestFacing(int[] buildings) {
        ArrayList<Integer> views = new ArrayList<>(); // use this as a deque

        for (int length = buildings.length, i = length - 1; i >= 0; i--) {
            int height = buildings[i];
            while (!views.isEmpty() && height >= buildings[views.getFirst()]) {
                views.removeFirst();
            }
            views.addFirst(i);
        }

        return views;
    }

}
