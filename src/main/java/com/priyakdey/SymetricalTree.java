package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SymetricalTree {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean symmetricalTree(BinaryTree tree) {
        if (tree == null || (tree.left == null && tree.right == null)) return true;
        return symmetricalTree(tree.left, tree.right);
    }

    private boolean symmetricalTree(BinaryTree leftNode, BinaryTree rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;

        return leftNode.value == rightNode.value
            && symmetricalTree(leftNode.left, rightNode.right)
            && symmetricalTree(leftNode.right, rightNode.left);
    }
}
