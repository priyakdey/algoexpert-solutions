package com.priyakdey;

import java.util.stream.IntStream;

/**
 * @author Priyak Dey
 */
public class MaxPathSum {

    // Recurse over every node. Max Path sum at that node =
    // max(node.value, node.value + left_sum, node.value + right_sum,
    // node.value + left_sum + right_sum)
    // But for return max(node.value, node.value + left_sum,
    // node.value + right_sum, node.value)

    public static int maxPathSum(BinaryTree tree) {
        int[] maxPathSum = new int[]{Integer.MIN_VALUE};
        maxPathSum(tree, maxPathSum);
        return maxPathSum[0];
    }

    private static int maxPathSum(BinaryTree tree, int[] maxPathSum) {
        if (tree == null) return 0;

        int leftSum = maxPathSum(tree.left, maxPathSum);
        int rightSum = maxPathSum(tree.right, maxPathSum);

        maxPathSum[0] = max(maxPathSum[0], tree.value, tree.value + leftSum,
                tree.value + rightSum, tree.value + leftSum + rightSum);

        return max(tree.value, tree.value + leftSum, tree.value + rightSum);
    }

    private static int max(int... elements) {
        assert elements.length > 0 : "No elements passed, should never happen";
        return IntStream.of(elements).max().getAsInt();
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
