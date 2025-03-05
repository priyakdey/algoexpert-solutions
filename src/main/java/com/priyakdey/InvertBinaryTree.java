package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class InvertBinaryTree {

    // Recurse down the tree and swap the left and right pointers.

    public static void invertBinaryTree(BinaryTree tree) {
        invertChidlren(tree);
    }

    private static BinaryTree invertChidlren(BinaryTree node) {
        if (node == null) return node;
        if (node.left == null && node.right == null) return node;

        BinaryTree left = node.left, right = node.right;
        node.left = invertChidlren(right);
        node.right = invertChidlren(left);

        return node;
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
