package com.priyakdey;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class SameBsts {

    // The first element should be the root of the tree/subtree.
    // All elements < first element is the left subtree nodes and
    // others are right subtree elements.
    // Generate the list of left subtree and right subtree respectively
    // for both tree and recursively check if tree is same.

    // TODO: What can be done to reduce memory footprint

    public static boolean sameBsts(List<Integer> arrayOne,
                                   List<Integer> arrayTwo) {
        if (arrayOne.isEmpty() && arrayTwo.isEmpty()) return true;
        if (arrayOne.isEmpty() || arrayTwo.isEmpty()) return false;

        if (!Objects.equals(arrayOne.getFirst(), arrayTwo.getFirst())
                || arrayOne.size() != arrayTwo.size()) {
            return false;
        }

        List<Integer>[] arr1 = generateSubtree(arrayOne);
        List<Integer> arrayOneLeftSubtree = arr1[0];
        List<Integer> arrayOneRightSubtree = arr1[1];

        List<Integer>[] arr2 = generateSubtree(arrayTwo);
        List<Integer> arrayTwoLeftSubtree = arr2[0];
        List<Integer> arrayTwoRightSubtree = arr2[1];

        return sameBsts(arrayOneLeftSubtree, arrayTwoLeftSubtree)
                && sameBsts(arrayOneRightSubtree, arrayTwoRightSubtree);
    }

    @SuppressWarnings("unchecked")
    private static List<Integer>[] generateSubtree(List<Integer> tree) {
        int root = tree.getFirst();
        List<Integer> leftSubtree = new ArrayList<>();
        List<Integer> rightSubtree = new ArrayList<>();

        for (int i = 1; i < tree.size(); i++) {
            int node = tree.get(i);
            if (node < root) {
                leftSubtree.add(node);
            } else {
                rightSubtree.add(node);
            }
        }

        return new List[]{leftSubtree, rightSubtree};
    }


}
