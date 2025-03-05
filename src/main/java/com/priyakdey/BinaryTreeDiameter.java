package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class BinaryTreeDiameter {

    // Find the height for left and right subtree at each node.
    // Max diameter at the node will be left height + right height.
    // Then return the max of the two for the parent node compute.

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        int[] maxDiameter = new int[]{0};
        binaryTreeDiameter(tree, maxDiameter);
        return maxDiameter[0];
    }

    private int binaryTreeDiameter(BinaryTree tree, int[] maxDiameter) {
        if (tree.left == null && tree.right == null) {
            maxDiameter[0] = Math.max(maxDiameter[0], 0);
            return 0;
        }

        int leftHeight = 0;
        if (tree.left != null) {
            leftHeight = 1 + binaryTreeDiameter(tree.left, maxDiameter);
        }

        int rightHeight = 0;
        if (tree.right != null) {
            rightHeight = 1 + binaryTreeDiameter(tree.right, maxDiameter);
        }

        int totalDiameter = leftHeight + rightHeight;
        maxDiameter[0] = Math.max(maxDiameter[0], totalDiameter);

        return Math.max(leftHeight, rightHeight);
    }

}
