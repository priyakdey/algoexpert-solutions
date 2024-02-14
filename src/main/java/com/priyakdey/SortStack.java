package com.priyakdey;

import java.util.ArrayList;

/**
 * @author Priyak Dey
 */
public class SortStack {

    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        ArrayList<Integer> sorted = new ArrayList<>();

        while (!stack.isEmpty()) {
            int value = stack.removeFirst();
            while (!sorted.isEmpty() && value > sorted.getFirst()) {
                stack.addFirst(sorted.removeFirst());
            }

            sorted.addFirst(value);
        }

        return sorted;
    }

}
