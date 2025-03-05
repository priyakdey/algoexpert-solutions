package com.priyakdey;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class SplitBinaryTree {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int splitBinaryTree(BinaryTree tree) {
        Set<Integer> sums =  new HashSet<>();
        int sum = splitBinaryTree(tree, sums);
        if ((sum & 1) == 1) return 0;
        int half = sum / 2;
        return sums.contains(half) ? half : 0;
    }

    private int splitBinaryTree(BinaryTree node, Set<Integer> sums) {
        if (node == null) return 0;

        int left = splitBinaryTree(node.left, sums);
        int right = splitBinaryTree(node.right, sums);
        int sum = node.value + left + right;
        sums.add(sum);
        return sum;
    }

}
