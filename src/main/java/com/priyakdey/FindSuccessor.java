package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class FindSuccessor {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        BinaryTree successor = node.right;
        while (successor != null && successor.left != null) {
            successor = successor.left;
        }

        if (successor != null) return successor;

        while (node.parent != null && node.parent.right == node) {
            node = node.parent;
        }

        return node.parent;
    }

}
