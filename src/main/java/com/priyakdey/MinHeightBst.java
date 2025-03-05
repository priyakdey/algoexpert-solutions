package com.priyakdey;

import java.util.List;

/**
 * @author Priyak Dey
 */
public class MinHeightBst {

    // With a sorted array, find the mid and create the node.
    // Recursively create nodes for left range and right range
    // for left subtree and right subtree respectively.

    public static BST minHeightBst(List<Integer> array) {
        return createNode(array, 0, array.size() - 1);
    }

    private static BST createNode(List<Integer> array, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        BST node = new BST(array.get(mid));
        node.left = createNode(array, left, mid - 1);
        node.right = createNode(array, mid + 1, right);
        return node;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

}
