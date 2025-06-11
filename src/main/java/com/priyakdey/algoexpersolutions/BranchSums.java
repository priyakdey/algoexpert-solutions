package com.priyakdey.algoexpersolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class BranchSums {

    // DFS down each root-to-leaf path, accumulating the sum — add to result only when a leaf
    // node is reached.


    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> acc = new ArrayList<>();
        branchSums(root, 0, acc);
        return acc;
    }

    private static void branchSums(BinaryTree root, int currSum, List<Integer> acc) {
        if (root == null) return;
        currSum += root.value;
        if (root.left == null && root.right == null) {
            acc.add(currSum);
            return;
        }

        branchSums(root.left, currSum, acc);
        branchSums(root.right, currSum, acc);
    }
}
