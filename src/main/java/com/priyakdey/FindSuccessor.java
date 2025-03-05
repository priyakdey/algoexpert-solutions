package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class FindSuccessor {

    // Successor for inorder traversal is:
    // -> if right child exists, go right and then extreme left.
    // -> if no, parent is the successor, when current node is the left
    // child of the parent.

    // This is an input class. Do not edit.
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

        if (successor != null) {
            return successor;
        }

        successor = node.parent;
        while (successor != null && node != successor.left) {
            node = successor;
            successor = successor.parent;
        }

        return successor;
    }

}
