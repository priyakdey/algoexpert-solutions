package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class SweetAndSavory {

    public int[] sweetAndSavory(int[] dishes, int target) {
        Arrays.sort(dishes);
        int sweetLeft = 0;
        int sweetRight = 0;
        int length = dishes.length;
        while (sweetRight < length && dishes[sweetRight] < 0) {
            sweetRight++;
        }
        sweetRight--;

        int[] pair = new int[]{0, 0};

        if (sweetRight == -1 || sweetRight == length - 1) {
            return pair;
        }

        int savoryLeft = sweetRight + 1;
        int savoryRight = length - 1;

        for (int i = savoryLeft; i <= savoryRight; i++) {
            int savory = dishes[i];
            int left = sweetLeft, right = sweetRight;
            int index = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int sweet = dishes[mid];
                if (sweet + savory <= target) {
                    index = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (index == -1) continue;
            int total = dishes[index] + savory;
            if (total <= target && total >= pair[0] + pair[1]) {
                pair[0] = dishes[index];
                pair[1] = savory;
            }
        }

        return pair;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SweetAndSavory().sweetAndSavory(new int[]{2, 5, -4, -7, 12, 100, -25}, 1)));
    }

}
