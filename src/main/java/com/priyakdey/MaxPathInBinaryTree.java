package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MaxPathInBinaryTree {

    public static int maxPathSum(BinaryTree tree) {
        int[] maxPathSum = new int[] {Integer.MIN_VALUE};
        pathSum(tree, maxPathSum);
        return maxPathSum[0];
    }

    private static int pathSum(BinaryTree tree, int[] maxPathSum) {
        if (tree == null) return Integer.MIN_VALUE;
        if (tree.left == null && tree.right == null) {
            maxPathSum[0] = Math.max(maxPathSum[0], tree.value);
            return tree.value;
        }

        int leftSum  = tree.left != null
            ? tree.value + pathSum(tree.left, maxPathSum)
            : tree.value;
        int rightSum =
            tree.right != null
                ? tree.value + pathSum(tree.right, maxPathSum)
                : tree.value;

        maxPathSum[0] = max(maxPathSum[0], leftSum + rightSum - tree.value, leftSum, rightSum);


        return max(leftSum, rightSum, tree.value);
    }

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private static int max(int a, int b, int c, int d) {
        return max(a, b, Math.max(c, d));
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
