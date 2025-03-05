package com.priyakdey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class Permutations {

    // Swap elements with an index and [index + 1...size], and then recurse.
    // Backtrack the solution for next iteration.

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> acc = new ArrayList<>();
        if (array.isEmpty()) {
            return acc;
        }
        getPermutations(array, 0, acc);
        return acc;
    }

    private static void getPermutations(List<Integer> array, int index,
                                        List<List<Integer>> permutations) {
        if (index == array.size()) {
            permutations.add(new ArrayList<>(array));
            return;
        }

        getPermutations(array, index + 1, permutations);

        for (int i = index + 1; i < array.size(); i++) {
            Collections.swap(array, index, i);
            getPermutations(array, index + 1, permutations);
            Collections.swap(array, index, i);
        }
    }
}
