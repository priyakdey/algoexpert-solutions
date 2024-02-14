package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class FindThreeLargestNumbers {

    public static int[] findThreeLargestNumbers(int[] array) {
        if (array == null || array.length < 3) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = array.length;

        int firstMax = array[0];
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;


        for (int i = 1; i < length; i++) {
            int value = array[i];
            if (value >= firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = value;
            } else if (value >= secondMax) {
                thirdMax = secondMax;
                secondMax = value;
            } else if (value >= thirdMax) {
               thirdMax = value;
            }
        }

        return new int[] {thirdMax, secondMax, firstMax};
    }

}
