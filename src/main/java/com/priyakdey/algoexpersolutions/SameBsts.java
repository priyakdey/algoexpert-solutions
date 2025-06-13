package com.priyakdey.algoexpersolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class SameBsts {

    // Recursively simulate BST insertions from two pre-order arrays — check if left/right
    // subtree partitions match structurally and by value.
    //
    // At each level, ensure root matches, then split remaining nodes into < root and ≥ root to
    // simulate BST behavior.
    // Recurse on left and right subtrees — if any mismatch occurs, the BSTs are not the same.

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size()) return false;
        if (arrayOne.isEmpty()) return true;
        if (!Objects.equals(arrayOne.get(0), arrayTwo.get(0))) return false;

        List<Integer>[] arrayOneSubtrees = generateSubtree(arrayOne, arrayOne.get(0));
        List<Integer>[] arrayTwoSubtrees = generateSubtree(arrayTwo, arrayTwo.get(0));

        return sameBsts(arrayOneSubtrees[0], arrayTwoSubtrees[0])
                && sameBsts(arrayOneSubtrees[1], arrayTwoSubtrees[1]);
    }

    private static List<Integer>[] generateSubtree(List<Integer> tree, int node) {
        List<Integer> leftSubtree = new ArrayList<>();
        List<Integer> rightSubtree = new ArrayList<>();

        for (int i = 1; i < tree.size(); i++) {
            int value = tree.get(i);
            if (value < node) {
                leftSubtree.add(value);
            } else {
                rightSubtree.add(value);
            }
        }

        return new List[]{leftSubtree, rightSubtree};
    }
}
