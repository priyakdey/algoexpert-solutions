package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class PowerSet {

    public static List<List<Integer>> powerset(List<Integer> array) {
        int noOfSubsets = (int) Math.pow(2, array.size());
        List<List<Integer>> subsets = new ArrayList<>(noOfSubsets);
        subsets.add(List.of());

        if (array.isEmpty()) return subsets;

        powerset(array, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void powerset(List<Integer> array, int index, List<Integer> subset,
                                 List<List<Integer>> subsets) {
        if (index == array.size()) return;

        // skip current element
        powerset(array, index + 1, subset, subsets);

        // take the current element for the subset
        subset.add(array.get(index));
        subsets.add(new ArrayList<>(subset));
        powerset(array, index + 1, subset, subsets);
        subset.removeLast();
    }

}
