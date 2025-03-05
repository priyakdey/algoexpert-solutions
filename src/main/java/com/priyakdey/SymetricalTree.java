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
        if (tree == null) return true;
        return symmetricalTree(tree.left, tree.right);
    }

    private boolean symmetricalTree(BinaryTree node1, BinaryTree node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.value == node2.value
                && symmetricalTree(node1.left, node2.right)
                && symmetricalTree(node1.right, node2.left);
    }
}
