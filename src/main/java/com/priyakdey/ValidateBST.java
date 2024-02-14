package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ValidateBST {

    public static boolean validateBst(BST tree) {
        return validateBst(tree, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validateBst(BST node, long lowerBound, long upperBound) {
        if (node == null) return true;
        return (node.value >= lowerBound && node.value < upperBound)
            && validateBst(node.left, lowerBound, node.value)
            && validateBst(node.right, node.value, upperBound);
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
