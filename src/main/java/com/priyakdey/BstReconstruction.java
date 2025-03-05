package com.priyakdey;

import java.util.ArrayList;

/**
 * @author Priyak Dey
 */
public class BstReconstruction {

    // The root of the subtree is the first element of the array/subarray.
    // To get the right and left preorder array, we can say, that from
    // current_index + 1 -> index where value < current node value (first
    // element of the subarray) is the left subtree and the right subtree is
    // represented by the rest of the array.
    // Recursively find the ranges of the array and create the nodes.

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        int size = preOrderTraversalValues.size();
        return reconstructBst(preOrderTraversalValues, 0, size - 1);
    }

    private BST reconstructBst(ArrayList<Integer> preOrderTraversalValues,
                               int left, int right) {
        if (left > right) return null;

        int value = preOrderTraversalValues.get(left);
        BST node = new BST(value);

        int index = findIndex(preOrderTraversalValues, value, left + 1, right);
        node.left = reconstructBst(preOrderTraversalValues, left + 1,
                index - 1);
        node.right = reconstructBst(preOrderTraversalValues, index, right);

        return node;
    }

    private int findIndex(ArrayList<Integer> array, int value, int left,
                          int right) {
        int index = left;
        for (; index <= right; index++) {
            if (array.get(index) >= value) {
                break;
            }
        }

        return index;
    }

}
