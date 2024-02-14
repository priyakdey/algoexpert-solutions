package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class HeightBalancedBinaryTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        int[] maxHeightDiff = new int[]{0};
        calculateHeightOfTree(tree, maxHeightDiff);
        return maxHeightDiff[0] <= 1;
    }

    private int calculateHeightOfTree(BinaryTree tree, int[] maxHeightDiff) {
        if (tree == null) return 0;
        if (tree.left == null && tree.right == null) return 0;

        int leftHeight =
            tree.left != null
                ? 1 + calculateHeightOfTree(tree.left, maxHeightDiff)
                : 0;
        int rightHeight =
            tree.right != null
                ? 1 + calculateHeightOfTree(tree.right, maxHeightDiff)
                : 0;

        int heightDiff = Math.abs(leftHeight - rightHeight);
        maxHeightDiff[0] = Math.max(maxHeightDiff[0], heightDiff);

        return Math.max(leftHeight, rightHeight);
    }

}
