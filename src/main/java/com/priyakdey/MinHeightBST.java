package com.priyakdey;

import java.util.List;

/**
 * @author Priyak Dey
 */
public class MinHeightBST {

    public static BST minHeightBst(List<Integer> array) {
        return minHeightBst(array, 0, array.size() - 1);
    }

    private static BST minHeightBst(List<Integer> array, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        BST node = new BST(array.get(mid));
        node.left  = minHeightBst(array, left, mid - 1);
        node.right = minHeightBst(array, mid + 1, right);
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
