package com.priyakdey.algoexpersolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class PowerSet {

    // Backtracking approach to build power set — include or exclude each element at every step.

    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> acc = new ArrayList<>();
        List<Integer> powerset = new ArrayList<>(array.size());
        acc.add(powerset);
        powerset(array, 0, powerset, acc);
        return acc;
    }

    private static void powerset(List<Integer> array, int index, List<Integer> powerset,
                                 List<List<Integer>> acc) {
        if (index == array.size()) {
            return;
        }

        powerset(array, index + 1, powerset, acc);

        acc.add(new ArrayList<>(powerset));
        powerset.add(array.get(index));

        powerset(array, index + 1, powerset, acc);

        powerset.remove(powerset.size() - 1);
    }

    // Use bitmasking to generate powerset:
    // Iterate over 0...2ⁿ - 1 and include elements where corresponding bit is set.

    private static List<List<Integer>> powersetBitmaskVersion(List<Integer> array) {
        int length = array.size();
        int total = 1 << length;

        List<List<Integer>> acc = new ArrayList<>();

        for (int mask = 0; mask < total; mask++) {
            List<Integer> powerset = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if ((mask & (1 << i)) != 0) {
                    powerset.add(array.get(i));
                }
            }

            acc.add(powerset);
        }

        return acc;
    }

}
