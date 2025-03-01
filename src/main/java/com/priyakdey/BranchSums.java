package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class BranchSums {

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

    // recurse down the tree and add the curr sum at each leaf node

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> currSums = new ArrayList<>();
        if (root == null) {
            return currSums;
        }
        branchSums(root, 0, currSums);
        return currSums;
    }

    private static void branchSums(BinaryTree root, int currSum,
                                   List<Integer> currSums) {
        currSum += root.value;
        if (root.left == null && root.right == null) {
            currSums.add(currSum);
            return;
        }

        if (root.left != null) {
            branchSums(root.left, currSum, currSums);
        }

        if (root.right != null) {
            branchSums(root.right, currSum, currSums);
        }
    }
}
