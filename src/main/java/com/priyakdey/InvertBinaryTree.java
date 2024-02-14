package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class InvertBinaryTree {

    public static void invertBinaryTree(BinaryTree tree) {
        invertBinaryTreeInternal(tree);
    }

    private static BinaryTree invertBinaryTreeInternal(BinaryTree tree) {
        if (tree == null || (tree.left == null && tree.right == null)) return tree;
        BinaryTree left  = invertBinaryTreeInternal(tree.right);
        BinaryTree right = invertBinaryTreeInternal(tree.left);
        tree.left  = left;
        tree.right = right;
        return tree;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
