package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ValidateBST {

    // Each node should be within the lower and upper bound.
    // Check each node and recursively check for left and right node validity.

    public static boolean validateBst(BST tree) {
        return validateBst(tree, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validateBst(BST tree, long lowerBound, long upperBound) {
        if (tree == null) {
            return true;
        }

        if (tree.value < lowerBound || tree.value >= upperBound) {
            return false;
        }

        return validateBst(tree.left, lowerBound, tree.value)
                && validateBst(tree.right, tree.value, upperBound);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

}
