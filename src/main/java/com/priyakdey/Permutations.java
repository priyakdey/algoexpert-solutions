package com.priyakdey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class Permutations {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        if (array.isEmpty()) return List.of();

        int noOfPermutations = calculateFactorial(array.size());
        List<List<Integer>> permutations = new ArrayList<>(noOfPermutations);
        getPermutations(array, 0, permutations);
        return  permutations;
    }

    private static void getPermutations(List<Integer> array, int index,
                                        List<List<Integer>> permutations) {
        if (index == array.size()) {
            permutations.add(new ArrayList<>(array));
            return;
        }

        // skip current element and move on
        getPermutations(array, index + 1, permutations);

        // consider current element and permute
        for (int i = index + 1; i < array.size(); i++) {
            Collections.swap(array, index, i);
            getPermutations(array, index + 1, permutations);
            Collections.swap(array, index, i);      // backtrack the swap
        }
    }

    private static int calculateFactorial(int n) {
        if (n <= 2) return n;
        int factorial = 2;
        for (int i = 3; i <= n; i++) {
            factorial *= i;
        }

        return factorial;
    }

}
