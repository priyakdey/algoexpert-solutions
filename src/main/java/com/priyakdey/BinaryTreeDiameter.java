package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class BinaryTreeDiameter {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        int[] maxDiameterRef = {0};
        maxHeight(tree, maxDiameterRef);
        return maxDiameterRef[0];
    }

    private int maxHeight(BinaryTree tree, int[] maxDiameterRef) {
        if (tree == null) return 0;
        if (tree.left == null && tree.right == null) return 0;

        int leftHeight = tree.left != null ? 1 + maxHeight(tree.left, maxDiameterRef) : 0;
        int rightHeight = tree.right != null ? 1 + maxHeight(tree.right, maxDiameterRef) : 0;

        int diameter = leftHeight + rightHeight;
        maxDiameterRef[0] = Math.max(maxDiameterRef[0], diameter);

        return Math.max(leftHeight, rightHeight);
    }

}
