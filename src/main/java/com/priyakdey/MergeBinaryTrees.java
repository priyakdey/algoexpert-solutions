package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MergeBinaryTrees {

    // Recurse down both trees at the same time.
    // If both not null, return a new node with the sum.
    // If either of them null, return the non-null node.
    // If both are null, return null!


    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
        if (tree1 == null && tree2 == null) {
            return null;
        }
        if (tree1 == null) {
            return tree2;
        }
        if (tree2 == null) {
            return tree1;
        }

        int value = tree1.value + tree2.value;
        BinaryTree node = new BinaryTree(value);
        node.left = mergeBinaryTrees(tree1.left, tree2.left);
        node.right = mergeBinaryTrees(tree1.right, tree2.right);
        return node;
    }

}
