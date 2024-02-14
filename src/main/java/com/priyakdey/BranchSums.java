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

    public static List<Integer> branchSums(BinaryTree root) {
        if (root == null) return List.of();
        if (root.left == null && root.right == null) return List.of(root.value);
        List<Integer> branchSums = new ArrayList<>();
        branchSums(root, 0, branchSums);
        return branchSums;
    }

    private static void branchSums(BinaryTree root, int sum, List<Integer> branchSums) {
        if (root.left == null && root.right == null) {
            sum += root.value;
            branchSums.add(sum);
            return;
        }

        if (root.left != null)  branchSums(root.left, sum + root.value, branchSums);
        if (root.right != null) branchSums(root.right, sum + root.value, branchSums);
    }
}
