package com.priyakdey;

import java.util.Collections;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class MoveElementToEnd {

    // Have two pointers from extreme ends and decide for a swap

    public static List<Integer> moveElementToEnd(List<Integer> array,
                                                 int toMove) {
        int left = 0, right = array.size() - 1;

        while (left < right) {
            int x = array.get(left), y = array.get(right);
            if (x == toMove && y == toMove) {
                right--;
            } else if (x == toMove && y != toMove) {
                Collections.swap(array, left, right);
                left++;
                right--;
            } else if (x != toMove && y == toMove) {
                left++;
                right--;
            } else {
                left++;
            }
        }

        return array;
    }

}
