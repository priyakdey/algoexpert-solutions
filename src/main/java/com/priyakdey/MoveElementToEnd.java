package com.priyakdey;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class MoveElementToEnd {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        Objects.requireNonNull(array);
        int size = array.size();
        if (size <= 1) return array;

        int left = 0, right = size - 1;

        while(left < right) {
            if (array.get(left) == toMove && array.get(right) == toMove) {
                right--;
            } else if (array.get(left) == toMove && array.get(right) != toMove) {
                Collections.swap(array, left, right);
                left++;
                right--;
            } else if (array.get(left) != toMove && array.get(right) == toMove) {
                left++;
                right--;
            } else if (array.get(left) != toMove && array.get(right) != toMove) {
                left++;
            }
        }

        return array;
    }

}
