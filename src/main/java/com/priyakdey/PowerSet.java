package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class PowerSet {

    // Use recursion and backtracking to solve this problem.
    // Since all unique elements, we don't need to do anything special.

    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> acc = new ArrayList<>();
        powerset(array, 0, new ArrayList<>(), acc);
        return acc;
    }

    private static void powerset(List<Integer> array, int index,
                                 List<Integer> buf, List<List<Integer>> acc) {
        if (index == array.size()) {
            acc.add(new ArrayList<>(buf));
            return;
        }

        powerset(array, index + 1, buf, acc);

        buf.add(array.get(index));
        powerset(array, index + 1, buf, acc);
        buf.removeLast();
    }

}
