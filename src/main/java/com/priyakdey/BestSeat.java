package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class BestSeat {

    // Find the maximum range of continuous zeroes

    public int bestSeat(int[] seats) {
        int length = seats.length;
        int cursor = 0;
        int maxRange = 0;
        int bestSeat = -1;

        while (cursor < length) {
            if (seats[cursor] == 1) {
                cursor++;
            } else {
                int start = cursor;
                while (cursor < length && seats[cursor] == 0) {
                    cursor++;
                }
                int range = cursor - start;
                if (range > maxRange) {
                    maxRange = range;
                    bestSeat = start + (cursor - 1 - start) / 2;
                }
            }
        }
        return bestSeat;
    }

}
