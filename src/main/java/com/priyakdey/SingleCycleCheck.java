package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SingleCycleCheck {

    // Jump through the array using each value as an index offset.
    // If we revisit index 0 before covering all elements, return false.
    // If after exactly N jumps we are back at index 0, it's a valid cycle.

    public static boolean hasSingleCycle(int[] array) {
        int jumps = 0, curr = 0;
        while (jumps < array.length) {
            if (jumps > 0 && curr == 0) {
                return false;
            }
            jumps++;
            curr = properMod(curr + array[curr], array.length);
        }

        return curr == 0;
    }

    private static int properMod(int a, int b) {
        return ((a % b) + b) % b;
    }

}
