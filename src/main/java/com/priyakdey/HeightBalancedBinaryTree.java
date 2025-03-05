package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class HeightBalancedBinaryTree {

    // Recurse down the tree to find the left and right subtree heights.
    // Find max diff and see that max diff for any node does not cross 1.


    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        int[] diff = new int[] {0};
        heightAtNode(tree, diff);
        return diff[0] < 2;
    }

    private int heightAtNode(BinaryTree tree, int[] diff) {
        if (tree.left == null && tree.right == null) {
            return 0;
        }

        int leftHeight = 0;
        int rightHeight = 0;

        if (tree.left != null) {
            leftHeight = 1 + heightAtNode(tree.left, diff);
        }
        if (tree.right != null) {
            rightHeight = 1 + heightAtNode(tree.right, diff);
        }

        diff[0] = Math.max(diff[0], Math.abs(leftHeight - rightHeight));
        return Math.max(leftHeight, rightHeight);
    }
}
