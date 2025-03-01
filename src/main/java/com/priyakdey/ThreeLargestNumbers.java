package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ThreeLargestNumbers {

    // Init 3 variables with INT_MIN. Iterate over the array
    // and compare with each variable to decide on the largest numbers.

    public static int[] findThreeLargestNumbers(int[] array) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int num : array) {
            if (num >=  first) {
                third = second;
                second = first;
                first = num;
            } else if (num >= second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
        }

        return new int[]{third, second, first};
    }

}
